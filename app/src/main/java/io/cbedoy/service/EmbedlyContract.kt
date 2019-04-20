package io.cbedoy.service

import io.cbedoy.models.Metadata
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EmbedlyContract {
    interface IEmbedlyInteractor{
        fun requestFromURLWithCallback(url: String, callback: EmbedlyCallback)
    }

    interface IEmbedlyPresenter{
        fun getMetadataFromURL(url: String, callback: EmbedlyCallback)
    }

    interface EmbedlyCallback {
        fun onCreatedMetadata()
    }

    interface IEmbedlyService{
        @GET("/1/extract")
        fun getExtractLink(@Query("url") url: String, @Query("key") key: String): Call<Metadata>
    }
}