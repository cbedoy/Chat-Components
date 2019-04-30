package io.cbedoy.holders.message

import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.HORIZONTAL
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import com.vstechlab.easyfonts.EasyFonts
import io.cbedoy.R
import io.cbedoy.adapter.ReactionAdapter
import io.cbedoy.holders.base.BaseMessageHolder
import io.cbedoy.models.Message
import io.cbedoy.utils.Utils
import kotlinx.android.synthetic.main.chat_message_view.*


open class ChatMessagePlainHolder(override val containerView: View) : BaseMessageHolder(containerView){
    override fun reload(data: Any) {
        data as Message

        val text = data.text
        val url = Utils.extractURL(text)

        chat_message_view_text.typeface = EasyFonts.robotoRegular(containerView.context)

        if (url != null && url.isNotEmpty()){

            val color = ContextCompat.getColor(containerView.context, R.color.link_color)
            val positionsOfUrl = Utils.positionsOfUrl(url)
            val spannableString = SpannableString(text)

            if (positionsOfUrl.isNotEmpty()){
                spannableString.setSpan(ForegroundColorSpan(color), positionsOfUrl[0], positionsOfUrl[1], 0)
            }
            chat_message_view_text.text = spannableString
        }else{
            chat_message_view_text.text = data.text
        }

        if (data.reactions.size > 0){
            val reactionAdapter = ReactionAdapter()
            reactionAdapter.dataModel = data.reactions

            chat_message_view_reactions_recycler_view.hasFixedSize()
            chat_message_view_reactions_recycler_view.layoutManager = LinearLayoutManager(containerView.context, HORIZONTAL, false)
            chat_message_view_reactions_recycler_view.adapter = reactionAdapter
        }

        val layoutParams = chat_message_view_reactions_recycler_view.layoutParams
        layoutParams.height = if (data.reactions.size == 0 ) 0 else Utils.convertDpToPixel(30, containerView.context)

        chat_message_view_reactions_recycler_view.layoutParams = layoutParams
    }
}