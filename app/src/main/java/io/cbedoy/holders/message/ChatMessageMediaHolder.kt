package io.cbedoy.holders.message

import android.view.View
import com.bumptech.glide.Glide
import com.vstechlab.easyfonts.EasyFonts
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.Message
import kotlinx.android.synthetic.main.chat_plain_media_message.*

class ChatMessageMediaHolder(override val containerView: View) : ChatMessagePlainHolder(containerView){
    override fun reload(data: Any) {
        super.reload(data)
        data as Message

        chat_plain_message_media_service.text = data.metadata?.provider_name
        chat_plain_message_media_title.text = data.metadata?.title
        chat_plain_message_media_description.text = data.metadata?.description

        chat_plain_message_media_service.typeface = EasyFonts.robotoRegular(containerView.context)
        chat_plain_message_media_title.typeface = EasyFonts.robotoBlack(containerView.context)
        chat_plain_message_media_description.typeface = EasyFonts.robotoMedium(containerView.context)

        if (data.metadata != null && data.metadata?.images != null){
            val images = data.metadata?.images
            if (images?.size!! > 0){
                val image = images[0]

                Glide.with(containerView).load(image.url).into(chat_plain_message_media_preview)
            }
        }
    }
}