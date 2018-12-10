package com.grishberg.layoutmanagersample.rv

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.grishberg.layoutmanagersample.ItemData
import com.grishberg.layoutmanagersample.R

class CardsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.itemTitle)
    val icon = view.findViewById<ImageView>(R.id.itemIcon)

    fun bind(item: ItemData) {
        item.updateIcon(icon)
        item.updateText(title)
    }
}