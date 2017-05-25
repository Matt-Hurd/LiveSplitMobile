package me.livesplitmobile.component

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import java.util.ArrayList

/**
 * Created by MidKnight on 5/14/2017.
 */

class SplitsAdapter(context: Context, splits: ArrayList<Split>) : ArrayAdapter<Split>(context, 0, splits) {

    override fun getView(position: Int, convertViewIn: View?, parent: ViewGroup): View {
        var convertView = convertViewIn
        val split = getItem(position)

        if (convertView == null) {
            convertView = SplitView(context, null)
        }

        val sv = convertView as SplitView
        sv.update(split)

        return sv
    }
}
