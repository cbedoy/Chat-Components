package io.cbedoy.utils

import android.content.Context
import io.cbedoy.BuildConfig
import io.cbedoy.utils.Utils.hasNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitUtil{

    lateinit var retrofit: Retrofit

    fun init(context: Context){
        val cache = Cache(context.cacheDir, Utils.cacheSize)

        val level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.level = level

        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(context)!!)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
            .addInterceptor(logging)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.EMBEDLY_ENDPOINT)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}