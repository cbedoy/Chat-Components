package io.cbedoy.holders.message

import android.view.View
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.Message
import kotlinx.android.synthetic.main.chat_plain_message.*

class ChatMessagePlainHolder(override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {

        data as Message

        chat_plain_message_text.text = data.text
    }
}