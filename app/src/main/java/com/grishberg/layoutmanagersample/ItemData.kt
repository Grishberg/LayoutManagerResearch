package com.grishberg.layoutmanagersample

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView

class ItemData(private val title: String, private val icon: Drawable) {
    fun updateText(titleTextView: TextView) {
        titleTextView.text = title
    }

    fun updateIcon(iconView: ImageView) {
        iconView.setImageDrawable(icon)
    }
}