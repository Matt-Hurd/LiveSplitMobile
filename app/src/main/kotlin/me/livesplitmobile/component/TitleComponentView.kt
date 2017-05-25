package me.livesplitmobile.component

import android.graphics.BitmapFactory.decodeByteArray
import android.view.ViewGroup.LayoutParams.MATCH_PARENT

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.util.Base64
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import butterknife.Bind

import butterknife.ButterKnife

import livesplitcore.Timer
import livesplitcore.TitleComponent
import livesplitcore.TitleComponentStateRef
import me.livesplitmobile.MainActivity
import me.livesplitmobile.R

/**
 * Created by MidKnight on 5/15/2017.
 */

class TitleComponentView(context: Context, attr: AttributeSet?, internal var timer: Timer, internal var runHandler: Handler) : LinearLayout(context, attr), IComponent {
    override var runnable: Runnable? = null
    internal var component: TitleComponent = TitleComponent()

    @Bind(R.id.tvSpacer)
    internal var tvSpacer: Space? = null

    @Bind(R.id.tvGameIcon)
    internal var tvGameIcon: ImageView? = null

    @Bind(R.id.tvGameLLayout)
    internal var tvGameLLayout: LinearLayout? = null

    @Bind(R.id.tvGameCategory)
    internal var tvGameCategory: TextView? = null

    @Bind(R.id.tvGameTitle)
    internal var tvGameTitle: TextView? = null

    @Bind(R.id.tvAttemptCount)
    internal var tvAttemptCount: TextView? = null

    init {

        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.title_view, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        ButterKnife.bind(this)
        runnable = Runnable {
            val state = component.state(timer)
            if (state != null) {
                update(state)
                state.close()
            } else {
                throw Exception("this shit probably shouldn't be null")
            }
            runHandler.postDelayed(runnable, MainActivity.INTERVAL)
        }
    }

    override fun run() {
        runHandler.postDelayed(runnable, MainActivity.INTERVAL)
    }

    fun update(state: TitleComponentStateRef) {
        val iconChange = state.iconChange()
        if (iconChange.isEmpty()) {
            tvGameIcon!!.setImageResource(0)
            tvGameIcon!!.layoutParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 0.0f)
            tvGameLLayout!!.gravity = Gravity.CENTER

            val lp = LinearLayout.LayoutParams(0, MATCH_PARENT, 0.1f)
            lp.setMargins(12, 0, 0, 0)
            tvSpacer!!.layoutParams = lp

            tvGameCategory!!.layoutParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 0.8f)
            tvGameCategory!!.gravity = Gravity.CENTER

        } else {
            val decodedString = Base64.decode(iconChange.substring(13), Base64.DEFAULT)
            val bitMap = decodeByteArray(decodedString, 0, decodedString.size)

            val ivLayoutParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 0.1f)
            ivLayoutParams.setMargins(18, 0, 18, 0)
            tvGameIcon!!.layoutParams = ivLayoutParams
            tvGameIcon!!.setImageBitmap(bitMap)

            tvGameLLayout!!.gravity = Gravity.START

            val lp = LinearLayout.LayoutParams(0, MATCH_PARENT, 0.0f)
            lp.setMargins(0, 0, 0, 0)
            tvSpacer!!.layoutParams = lp

            tvGameCategory!!.layoutParams = LinearLayout.LayoutParams(0, MATCH_PARENT, 0.9f)
            tvGameCategory!!.gravity = Gravity.START
        }
        tvGameTitle!!.text = state.game()
        tvGameCategory!!.text = state.category()
        tvAttemptCount!!.text = state.attempts().toString()
    }

}
