package me.livesplitmobile.component

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import me.livesplitmobile.Colors
import me.livesplitmobile.R

/**
 * Created by Cristobal on 5/14/2017.
 */

class SplitView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    internal val scale = getContext().resources.displayMetrics.density

    init {

        val a = context.obtainStyledAttributes(
                attrs,
                R.styleable.SplitView, 0, 0
        )

        a.recycle()
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.split_view, this, true)


        val height = (31.2 * scale + 0.5f).toInt()
        layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)

    }

    fun update(split: Split) {
        val imageView = findViewById(R.id.svImage) as ImageView
        if (split.showIconSpace) {
            imageView.setImageBitmap(split.icon)
            val pixels = (30 * scale + 0.5f).toInt()
            imageView.layoutParams = LinearLayout.LayoutParams(pixels, ViewGroup.LayoutParams.MATCH_PARENT, .07f)
        } else {
            imageView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 0f)
        }

        if (split.isCurrentSplit) {
            background = currentSplitGradient
        } else {
            if (split.index % 2 == 0) {
                setBackgroundColor(Color.TRANSPARENT)
            } else {
                background = ResourcesCompat.getDrawable(resources, R.drawable.split_border, null)
            }
        }

        val nameTextView = findViewById(R.id.svName) as TextView
        nameTextView.text = split.name

        val deltaTextView = findViewById(R.id.svDelta) as TextView
        deltaTextView.text = split.delta
        deltaTextView.setTextColor(Colors.colorFromString(split.colorName!!))
        (findViewById(R.id.svTime) as TextView).text = split.time
    }

    companion object {

        internal val currentSplitGradient = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xFF2e66d6.toInt(), 0xFF163779.toInt()))
    }
}
