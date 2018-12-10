package com.grishberg.layoutmanagersample.rv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.grishberg.layoutmanagersample.ItemData
import com.grishberg.layoutmanagersample.R

class CardsAdapter : RecyclerView.Adapter<CardsViewHolder>() {
    private val items = ArrayList<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return CardsViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateItems(createItems: List<ItemData>) {
        items.clear()
        items.addAll(createItems)
    }
}