package com.grishberg.layoutmanagersample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.grishberg.layoutmanagersample.rv.CardsAdapter
import com.grishberg.layoutmanagersample.rv.SampleLayoutManager

class MainActivity : AppCompatActivity() {
    private var state = State()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        state = CreatedState(findViewById(R.id.recyclerView))
        state.onCreated()
    }


    private open class State {
        open fun onCreated() = Unit
    }

    private inner class CreatedState(private val rv: RecyclerView) : State() {
        override fun onCreated() {
            val cardsAdapter = CardsAdapter()
            rv.adapter = cardsAdapter
            rv.layoutManager = SampleLayoutManager()
            cardsAdapter.updateItems(createItems())
        }
    }

    private fun createItems(): List<ItemData> {
        val items = ArrayList<ItemData>()
        for (i in 0..20) {
            val icon = ContextCompat.getDrawable(this, android.R.drawable.ic_btn_speak_now)
            icon?.let {
                items.add(
                    ItemData(
                        "item many many more more text, Once I am go to forest and it was very very cold ${i + 1}",
                        icon
                    )
                )
            }
        }
        return items
    }
}
