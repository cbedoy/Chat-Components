package io.cbedoy.holders

import android.view.View
import com.vstechlab.easyfonts.EasyFonts
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.DateMessage
import io.cbedoy.utils.TimeAgoUtils
import kotlinx.android.synthetic.main.chat_message_date.*

class ChatDateHolder(override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {
        data as DateMessage

        chat_message_date_separator.text = TimeAgoUtils.getTimeAgoAsSeparator(data.date.time)
        chat_message_date_separator.typeface = EasyFonts.robotoBlack(containerView.context)
    }
}