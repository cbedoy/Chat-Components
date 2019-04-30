package io.cbedoy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.cbedoy.R
import io.cbedoy.holders.ReactionHolder
import io.cbedoy.models.Reaction

class ReactionAdapter : RecyclerView.Adapter<ReactionHolder>() {

    var dataModel = ArrayList<Reaction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReactionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_reaction_view, parent, false)
        return ReactionHolder(view)
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    override fun onBindViewHolder(holder: ReactionHolder, position: Int) {
        holder.reload(dataModel[position])
    }

}