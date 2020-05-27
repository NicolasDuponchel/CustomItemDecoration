package com.nduponchel.itemdecorationdemo.decorator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.nduponchel.itemdecorationdemo.R
import com.nduponchel.itemdecorationdemo.adapter.CustomAdapter

class CustomItemTypeDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val decorationRed = ContextCompat.getDrawable(context, R.drawable.item_decoration_red)!!
    private val decorationBlue = ContextCompat.getDrawable(context, R.drawable.item_decoration_blue)!!

    override fun getItemOffsets(rect: Rect, view: View, parent: RecyclerView, s: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            val childAdapterPosition = parent.getChildAdapterPosition(view)
                .let { if (it == RecyclerView.NO_POSITION) return else it }

            rect.right = when (adapter.getItemViewType(childAdapterPosition)) {
                CustomAdapter.EVEN_ITEM_ID -> decorationRed.intrinsicWidth
                CustomAdapter.ODD_ITEM_ID -> decorationBlue.intrinsicWidth
                else -> 0
            }
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            parent.children
                .forEach { view ->
                    val childAdapterPosition = parent.getChildAdapterPosition(view)
                        .let { if (it == RecyclerView.NO_POSITION) return else it }

                    when (adapter.getItemViewType(childAdapterPosition)) {
                        CustomAdapter.EVEN_ITEM_ID -> decorationRed.drawSeparator(view, parent, canvas)
                        CustomAdapter.ODD_ITEM_ID -> decorationBlue.drawSeparator(view, parent, canvas)
                        else -> Unit
                    }
                }
        }
    }

    private fun Drawable.drawSeparator(view: View, parent: RecyclerView, canvas: Canvas) =
        apply {
            val left = view.right
            val top = parent.paddingTop
            val right = left + intrinsicWidth
            val bottom = top + intrinsicHeight - parent.paddingBottom
            bounds = Rect(left, top, right, bottom)
            draw(canvas)
        }

}