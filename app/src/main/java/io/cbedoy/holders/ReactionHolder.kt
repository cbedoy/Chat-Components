package io.cbedoy.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.cbedoy.models.Reaction
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.chat_message_reaction_view.*

class ReactionHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun reload(reaction: Reaction){
        chat_message_reaction_item.text = reaction.emoji
        chat_message_reaction_count.text = "${reaction.count}"
    }
}