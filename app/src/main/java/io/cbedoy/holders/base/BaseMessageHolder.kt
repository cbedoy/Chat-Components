package io.cbedoy.holders.base

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class BaseMessageHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{
    abstract fun reload(data: Any)
}