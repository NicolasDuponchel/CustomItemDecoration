package com.nduponchel.itemdecorationdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nduponchel.itemdecorationdemo.adapter.CustomAdapter
import com.nduponchel.itemdecorationdemo.adapter.MainAdapter
import com.nduponchel.itemdecorationdemo.decorator.CustomItemTypeDecoration
import com.nduponchel.itemdecorationdemo.decorator.CustomPositionItemDecoration
import com.nduponchel.itemdecorationdemo.decorator.DividerItemDecorationLastExcluded
import com.nduponchel.itemdecorationdemo.decorator.SimpleDividerItemDecorationLastExcluded
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainList = listOf(1, 2, 3, 4, 5, 6)
    private val mainAdapter = MainAdapter(mainList)
    private fun getManager() = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spaceItemDecorator()
        simpleItemDecorator()
        positionItemDecorator()
        typeItemDecorator()
    }

    private fun spaceItemDecorator() = with(spaceRecycler) {
        adapter = mainAdapter
        layoutManager = getManager()
        addItemDecoration(SimpleDividerItemDecorationLastExcluded(resources.getDimensionPixelSize(R.dimen.main_spacing)))
    }

    private fun simpleItemDecorator() = with(simpleRecycler) {
        adapter = mainAdapter
        layoutManager = getManager()
        addItemDecoration(DividerItemDecorationLastExcluded(context.getDrawable(R.drawable.item_decoration_red)!!))
    }

    private fun positionItemDecorator() = with(positionRecycler) {
        adapter = mainAdapter
        layoutManager = getManager()
        addItemDecoration(CustomPositionItemDecoration(context.getDrawable(R.drawable.item_decoration_red)!!))
    }

    private fun typeItemDecorator() = with(itemTypeRecycler) {
        adapter = CustomAdapter(mainList)
        layoutManager = getManager()
        addItemDecoration(CustomItemTypeDecoration(context))
    }


}
