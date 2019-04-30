package io.cbedoy.holders

import android.view.View
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.EventMessage
import kotlinx.android.synthetic.main.chat_message_event.*

class ChatEventHolder(override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {
        data as EventMessage

        chat_message_event_separator.text = data.event
    }
}