package io.cbedoy.holders

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import io.cbedoy.adapter.MessagesAdapter
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.GroupMessage
import io.cbedoy.utils.TimeAgoUtils
import kotlinx.android.synthetic.main.chat_message.*


class ChatGroupMessageHolder(override val containerView: View) : BaseMessageHolder(containerView) {
    override fun reload(data: Any) {
        data as GroupMessage

        chat_message_date.text = TimeAgoUtils.getTimeAgo(data.date.time)
        chat_message_nickname.text = data.user.nickname

        Glide.with(containerView).load(data.user.avatar).into(chat_message_avatar)

        val messagesAdapter = MessagesAdapter()
        messagesAdapter.dataModel = data.messages

        chat_message_recycler_view.adapter = messagesAdapter
        chat_message_recycler_view.layoutManager = LinearLayoutManager(containerView.context)
        chat_message_recycler_view.hasFixedSize()
    }
}