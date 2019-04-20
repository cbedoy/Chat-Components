package io.cbedoy.holders.message

import android.view.View
import com.bumptech.glide.Glide
import com.vstechlab.easyfonts.EasyFonts
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.Message
import kotlinx.android.synthetic.main.chat_plain_link_message.*

class ChatMessageLinkHolder(override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {
        data as Message

        val favIconURL = "https://www.google.com/s2/favicons?domain=${data.metadata?.url}"

        chat_plain_message_text.text = data.text
        chat_plain_link_message_container_service.text = data.metadata?.provider_name
        chat_plain_link_message_container_title.text = data.metadata?.title
        chat_plain_link_message_container_description.text = data.metadata?.description

        chat_plain_message_text.typeface = EasyFonts.robotoRegular(containerView.context)
        chat_plain_link_message_container_service.typeface = EasyFonts.robotoRegular(containerView.context)
        chat_plain_link_message_container_title.typeface = EasyFonts.robotoBlack(containerView.context)
        chat_plain_link_message_container_description.typeface = EasyFonts.robotoMedium(containerView.context)

        if (data.metadata != null && data.metadata?.images != null){
            val images = data.metadata?.images
            if (images?.size!! > 0){
                val image = images[0]

                Glide.with(containerView).load(image.url).into(chat_plain_link_message_container_thumbnail)
            }
        }

        Glide.with(containerView).load(favIconURL).into(chat_plain_link_message_fav_icon)
    }
}