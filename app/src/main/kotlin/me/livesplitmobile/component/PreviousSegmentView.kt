package me.livesplitmobile.component

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

import livesplitcore.PreviousSegmentComponent

/**
 * Created by MidKnight on 5/15/2017.
 */

class PreviousSegmentView(context: Context, attr: AttributeSet) : LinearLayout(context, attr), IComponent {
    internal var component: PreviousSegmentComponent? = null
    override var runnable: Runnable? = null

    override fun run() {}
}
