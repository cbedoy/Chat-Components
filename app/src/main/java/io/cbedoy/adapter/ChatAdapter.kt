package io.cbedoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.cbedoy.R
import io.cbedoy.holders.ChatDateHolder
import io.cbedoy.holders.ChatGroupMessageHolder
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.GroupMessage

open class ChatAdapter : RecyclerView.Adapter<BaseMessageHolder>() {

    var dataModel =  ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseMessageHolder {
        val any = dataModel[position]
        return if (any is GroupMessage){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message, parent, false)
            ChatGroupMessageHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_date, parent, false)
            ChatDateHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    override fun onBindViewHolder(holder: BaseMessageHolder, position: Int) {
        holder.reload(dataModel[position])
    }

}