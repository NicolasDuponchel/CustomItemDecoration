package com.nduponchel.itemdecorationdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nduponchel.itemdecorationdemo.R


class MainAdapter(private val items: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CustomViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.layout_item,
                    parent,
                    false
                )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)= Unit

    private class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)
}