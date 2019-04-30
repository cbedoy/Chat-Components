package io.cbedoy.models

import io.cbedoy.holders.protocols.IBaseMessageType
import io.cbedoy.holders.protocols.IBaseMessageType.TYPE.*
import io.cbedoy.utils.Utils
import java.util.*
import kotlin.collections.ArrayList

open class Message : IBaseMessageType {
    lateinit var user: User
    lateinit var text: String
    lateinit var date: Date
    var reactions =  ArrayList<Reaction>()
    var metadata: Metadata? = null

    override fun getType() : IBaseMessageType.TYPE {
        return if (metadata == null || metadata?.type == null)
            plain
        else {
            when {
                metadata?.type == "image" -> image
                metadata?.type == "html" -> {
                    val providerName = metadata?.provider_name
                    if (Utils.mediaHosts.contains(providerName?.toLowerCase())){
                        media
                    }else{
                        link
                    }
                }
                else -> media
            }
        }
    }

    constructor()

    constructor(text: String){
        this.text = text
    }
}