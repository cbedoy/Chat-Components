package io.cbedoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.cbedoy.R
import io.cbedoy.holders.ChatDateHolder
import io.cbedoy.holders.ChatEventHolder
import io.cbedoy.holders.ChatGroupMessageHolder
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.holders.protocols.IBaseMessage

class ChatAdapter : RecyclerView.Adapter<BaseMessageHolder>() {
    var dataModel =  ArrayList<IBaseMessage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMessageHolder {
        when (viewType) {
            IBaseMessage.MESSAGE.date.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_date, null, false)
                return ChatDateHolder(view)
            }
            IBaseMessage.MESSAGE.group.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message, parent, false)
                return ChatGroupMessageHolder(view)
            }
            IBaseMessage.MESSAGE.event.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_event, parent, false)
                return ChatEventHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_date, parent, false)
                return ChatDateHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataModel[position].getMessageType().ordinal
    }

    override fun onBindViewHolder(holder: BaseMessageHolder, position: Int) {
        holder.reload(dataModel[position])
    }

}