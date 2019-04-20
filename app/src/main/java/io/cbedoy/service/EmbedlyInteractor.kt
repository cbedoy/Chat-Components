package io.cbedoy.service

import io.cbedoy.BuildConfig
import io.cbedoy.ChatProvider
import io.cbedoy.models.Message
import io.cbedoy.models.Metadata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EmbedlyInteractor : EmbedlyContract.IEmbedlyInteractor{

    lateinit var service: EmbedlyContract.IEmbedlyService

    override fun requestFromURLWithCallback(url: String, callback: EmbedlyContract.EmbedlyCallback) {
        val call = service.getExtractLink(url, BuildConfig.EMBEDLY_KEY)
        call.enqueue(object : Callback<Metadata>{
            override fun onFailure(call: Call<Metadata>, t: Throwable) {

            }

            override fun onResponse(call: Call<Metadata>, response: Response<Metadata>) {
                processMessage(response, url, callback)
            }
        })
    }

    private fun processMessage(
        response: Response<Metadata>,
        url: String,
        callback: EmbedlyContract.EmbedlyCallback
    ) {
        if (response.isSuccessful){
            val message = Message()
            message.metadata = response.body()
            message.text = url
            message.user = ChatProvider.getUser()
            message.date = Date()

            ChatProvider.addMessage(message)
        }
        callback.onCreatedMetadata()
    }
}