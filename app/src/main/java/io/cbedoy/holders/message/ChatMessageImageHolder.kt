package io.cbedoy.holders.message

import android.view.View
import com.bumptech.glide.Glide
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.Message
import kotlinx.android.synthetic.main.chat_plain_image_message.*

class ChatMessageImageHolder (override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {
        data as Message

        chat_plain_message_text.text = data.text

        if (data.metadata != null && data.metadata?.images != null){
            val images = data.metadata?.images
            if (images?.size!! > 0){
                val image = images[0]

                Glide.with(containerView).load(image.url).into(chat_plain_image_message_container_thumbnail)
            }
        }
    }
}