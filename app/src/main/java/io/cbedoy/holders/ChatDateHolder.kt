package io.cbedoy.holders

import android.view.View
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.Message
import io.cbedoy.utils.TimeAgoUtils
import kotlinx.android.synthetic.main.chat_message_date.*

class ChatDateHolder(override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {
        data as Message

        chat_message_date_separator.text = TimeAgoUtils.getTimeAgoAsSeparator(data.date.time)
    }
}