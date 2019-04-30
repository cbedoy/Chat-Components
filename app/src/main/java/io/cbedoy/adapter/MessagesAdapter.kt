package io.cbedoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.cbedoy.R
import io.cbedoy.holders.ChatDateHolder
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.holders.message.ChatMessageImageHolder
import io.cbedoy.holders.message.ChatMessageLinkHolder
import io.cbedoy.holders.message.ChatMessageMediaHolder
import io.cbedoy.holders.message.ChatMessagePlainHolder
import io.cbedoy.holders.protocols.IBaseMessageType
import io.cbedoy.holders.protocols.IBaseMessageType.TYPE.*

class MessagesAdapter : RecyclerView.Adapter<BaseMessageHolder>() {
    var dataModel = ArrayList<IBaseMessageType>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMessageHolder {
        when (viewType){
            plain.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_message, parent, false)
                return ChatMessagePlainHolder(view)
            }
            link.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_link_message, parent, false)
                return ChatMessageLinkHolder(view)
            }
            image.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_image_message, parent, false)
                return ChatMessageImageHolder(view)
            }
            media.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_plain_media_message, parent, false)
                return ChatMessageMediaHolder(view)
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_date, parent, false)
        return ChatDateHolder(view)
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataModel[position].getType().ordinal
    }

    override fun onBindViewHolder(holder: BaseMessageHolder, position: Int) {
        holder.reload(dataModel[position])
    }
}