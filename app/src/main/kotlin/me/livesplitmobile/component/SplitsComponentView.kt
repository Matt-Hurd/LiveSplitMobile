package me.livesplitmobile.component

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Handler
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.util.Base64
import android.widget.ListView

import java.util.ArrayList

import livesplitcore.SplitsComponent
import livesplitcore.SplitsComponentStateRef
import livesplitcore.Timer
import me.livesplitmobile.MainActivity
import me.livesplitmobile.R

/**
 * Created by MidKnight on 5/14/2017.
 */

class SplitsComponentView(context: Context, attr: AttributeSet?, internal var timer: Timer, internal var timerHandler: Handler) : ListView(context, attr), IComponent {
    internal var component: SplitsComponent
    override var runnable: Runnable? = null
    internal var adapter: SplitsAdapter


    init {
        val splitArrayList = ArrayList<Split>()
        adapter = SplitsAdapter(context, splitArrayList)
        setAdapter(adapter)

        component = SplitsComponent()
        component.setVisualSplitCount(12)
        divider = ResourcesCompat.getDrawable(resources, R.drawable.list_view_divider, null)
        runnable = Runnable {
            val state = component.state(timer)
            if (state != null) {
                update(state)
                state.close()
            } else {
                throw Exception("Yo this should probably be initialized of something")
            }
            timerHandler.postDelayed(runnable, MainActivity.INTERVAL)
        }

    }

    override fun run() {
        timerHandler.postDelayed(runnable, MainActivity.INTERVAL)
    }

    fun update(state: SplitsComponentStateRef) {
        val split_count = state.len()
        var showIcons = false

        while (adapter.count < split_count) {
            adapter.add(Split())
        }

        while (adapter.count > split_count) {
            adapter.getItem(adapter.count - 1)
        }

        for (i in 0..split_count - 1) {
            val sv = adapter.getItem(i.toInt())
            val iconChange = state.iconChange(i)

            if (iconChange != null) {
                if (iconChange.isEmpty()) {
                    sv!!.icon = null
                } else {
                    val decodedString = Base64.decode(iconChange.substring(13), Base64.DEFAULT)
                    sv!!.icon = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
                }
            }

            showIcons = showIcons or (sv.icon != null)

            sv.isCurrentSplit = state.isCurrentSplit(i)
            sv.name = state.name(i)
            sv.delta = state.delta(i)
            sv.time = state.time(i)
            sv.colorName = state.color(i)
            sv.index = i.toInt()
        }

        for (i in 0..split_count - 1) {
            adapter.getItem(i.toInt())!!.showIconSpace = showIcons
        }

        adapter.notifyDataSetChanged()
    }
}
