package com.nduponchel.itemdecorationdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nduponchel.itemdecorationdemo.R

class CustomAdapter(private val items: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val backgroundRed = when (viewType) {
            ODD_ITEM_ID -> R.drawable.recycle_item
            EVEN_ITEM_ID -> R.drawable.recycle_item_2
            else -> throw Exception("Unknown view type")
        }
        return CustomViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_item, parent, false)
                .apply { background = ContextCompat.getDrawable(context, backgroundRed) }
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = Unit

    override fun getItemViewType(position: Int) =
        if (items[position] % 2 == 0) EVEN_ITEM_ID
        else ODD_ITEM_ID

    private class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

    companion object {
        const val ODD_ITEM_ID = 1
        const val EVEN_ITEM_ID = 2
    }
}