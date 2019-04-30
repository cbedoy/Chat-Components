package io.cbedoy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.cbedoy.service.EmbedlyContract
import io.cbedoy.service.EmbedlyInteractor
import io.cbedoy.service.EmbedlyPresenter
import io.cbedoy.utils.RetrofitUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import okhttp3.logging.HttpLoggingInterceptor.Level.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_view_controller)


        val links = arrayListOf(
            "https://cdn-images-1.medium.com/max/2100/1*UKYwzAEodyVMl6i33rwt-Q.jpeg",
            "https://open.spotify.com/track/4iDaYVSL0zwFLacCt0F7h9?si=SRQ6ycjBQWCuRWC55EPL_A",
            "https://web.whatsapp.com/",
            "https://www.facebook.com/tameimpala/",
            "https://www.youtube.com/watch?v=XcOHiGonWwU",
            "https://es.aliexpress.com/",
            "https://www.youtube.com/watch?v=gJuU-zjJMyk",
            "https://www.instagram.com/iambedoy/",
            "https://media.giphy.com/media/55vNDX5KNsaHsYepzt/giphy.mp4")



        val service = RetrofitUtil.retrofit.create(EmbedlyContract.IEmbedlyService::class.java)
        val presenter = EmbedlyPresenter()
        val interactor = EmbedlyInteractor()

        interactor.service = service
        presenter.interactor = interactor

        val done = arrayListOf<Boolean>()

        links.forEach {
            interactor.requestFromURLWithCallback(it, object : EmbedlyContract.EmbedlyCallback{
                override fun onCreatedMetadata() {
                    done.add(true)
                    if (done.size == links.size){
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    }
                }
            })
        }
    }
}