package io.cbedoy.models

import io.cbedoy.utils.Utils
import java.util.*

class Message{
    lateinit var user: User
    lateinit var text: String
    lateinit var date: Date
    var metadata: Metadata? = null

    fun getMessageType() : TYPE{
        return if (metadata == null || metadata?.type == null)
            TYPE.plain
        else {
            when {
                metadata?.type == "image" -> TYPE.image
                metadata?.type == "html" -> {
                    val providerName = metadata?.provider_name
                    if (Utils.mediaHosts.contains(providerName?.toLowerCase())){
                        TYPE.media
                    }else{
                        TYPE.link
                    }
                }
                else -> TYPE.media
            }
        }
    }

    constructor()

    constructor(text: String){
        this.text = text
    }

    enum class TYPE{
        link, plain, media, image
    }
}