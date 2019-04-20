package io.cbedoy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import io.cbedoy.R
import io.cbedoy.holders.ChatDateHolder
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.holders.message.ChatMessageImageHolder
import io.cbedoy.holders.message.ChatMessageLinkHolder
import io.cbedoy.holders.message.ChatMessageMediaHolder
import io.cbedoy.holders.message.ChatMessagePlainHolder
import io.cbedoy.models.Message

class MessagesAdapter : ChatAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseMessageHolder {
        val any = dataModel[position]
        if (any is Message){
            val type = any.getMessageType()
            when (type.ordinal){
                Message.TYPE.plain.ordinal -> {
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_message, parent, false)
                    return ChatMessagePlainHolder(view)
                }
                Message.TYPE.link.ordinal -> {
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_link_message, parent, false)
                    return ChatMessageLinkHolder(view)
                }
                Message.TYPE.image.ordinal -> {
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_image_message, parent, false)
                    return ChatMessageImageHolder(view)
                }
                Message.TYPE.media.ordinal -> {
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_media_message, parent, false)
                    return ChatMessageMediaHolder(view)
                }
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_date, parent, false)
        return ChatDateHolder(view)
    }
}