package me.livesplitmobile.component

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

import livesplitcore.Timer
import livesplitcore.TimerComponent
import me.livesplitmobile.Colors
import me.livesplitmobile.MainActivity
import me.livesplitmobile.R

/**
 * Created by MidKnight on 5/14/2017.
 */

class TimerComponentView(context: Context, attr: AttributeSet?, internal var timer: Timer, internal var timerHandler: Handler) : LinearLayout(context, attr), IComponent {
    internal var component: TimerComponent
    override var runnable: Runnable? = null

    init {
        val a = context.obtainStyledAttributes(
                attr,
                R.styleable.TimerComponentView, 0, 0
        )

        a.recycle()

        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.timer_component, this, true)
        component = TimerComponent()
        runnable = Runnable {
            val state = component.state(timer)
            val t = state!!.time()
            val f = state.fraction()
            val colorName = state.color()
            update(t, f, colorName)
            state.close()
            timerHandler.postDelayed(runnable, MainActivity.INTERVAL)
        }
    }

    override fun run() {
        timerHandler.postDelayed(runnable, MainActivity.INTERVAL)
    }

    fun update(t: String, f: String, colorName: String) {
        val ll = getChildAt(0) as LinearLayout
        val time = ll.findViewById(R.id.timeTime) as TextView
        time.text = t
        time.setTextColor(Colors.colorFromString(colorName))
        val frac = ll.findViewById(R.id.timeFrac) as TextView
        frac.text = f
        frac.setTextColor(Colors.colorFromString(colorName))
    }
}
