package me.livesplitmobile

import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout

import livesplitcore.Run
import livesplitcore.Segment
import livesplitcore.Timer

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.util.ArrayList

import me.livesplitmobile.component.IComponent
import me.livesplitmobile.component.SplitsComponentView
import me.livesplitmobile.component.TimerComponentView
import me.livesplitmobile.component.TitleComponentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = 0xFF000000.toInt()

        createTimerInstance()
        addComponents()
    }

    private fun addComponents() {
        val mainLayout = findViewById(R.id.mainLayout) as LinearLayout
        val context = mainLayout.context

        val tcv = TimerComponentView(context, null, timer, runHandler)
        mainLayout.addView(tcv, 0)
        components.add(tcv)

        val scv = SplitsComponentView(context, null, timer, runHandler)
        scv.isVerticalScrollBarEnabled = false
        mainLayout.addView(scv, 0)
        components.add(scv)

        val titleComponentView = TitleComponentView(context, null, timer, runHandler)
        titleComponentView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0f
        )
        mainLayout.addView(titleComponentView, 0)
        components.add(titleComponentView)

        for (c in components) {
            c.run()
        }
    }

    private fun createTimerInstance() {
        var run: Run? = null
        if (isPermissionGranted(android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
            try {
                val sdCard = Environment.getExternalStorageDirectory()
                Log.d("D", sdCard.list()[0])
                val dir = File(sdCard.absolutePath + "/LiveSplit")
                dir.mkdirs()
                val file = File(dir, "splits.lss")
                Log.d("SplitsPath", file.toString())
                val s = FileInputStream(file)
                val reader = BufferedReader(InputStreamReader(s))
                val sb = StringBuilder()
                var line: String? = null
                line = reader.readLine()
                while (line != null) {
                    sb.append(line).append("\n")
                    line = reader.readLine()
                }
                reader.close()
                val content = sb.toString()
                run = Run.parse(content)
            } catch (e: IOException) {
                Log.d("D", e.toString())
            }

        }
        if (run == null) {
            run = Run()
            run.setGameName("The Legend of Zelda: The Wind Waker")
            run.setCategoryName("Any%")
            run.pushSegment(Segment("Hero's Sword"))
            run.pushSegment(Segment("Leaving Outset"))
            run.pushSegment(Segment("Forsaken Fortress 1"))
            run.pushSegment(Segment("Wind Waker"))
            run.pushSegment(Segment("Empty Bottle"))
            run.pushSegment(Segment("Delivery Bag"))
            run.pushSegment(Segment("Kargaroc Key"))
            run.pushSegment(Segment("Grappling Hook"))
            run.pushSegment(Segment("Enter Gohma"))
            run.pushSegment(Segment("Dragon Roost Cavern"))
            run.pushSegment(Segment("Northern Triangle"))
            run.pushSegment(Segment("Greatfish"))
        }
        timer = Timer(run)
    }

    fun startSplitClicked(view: View) {
        timer.split()
    }

    fun isPermissionGranted(permission: String): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                Log.v("Ok", "Permission is granted")
                return true
            } else {

                Log.v("Ok", "Permission is revoked")
                ActivityCompat.requestPermissions(this, arrayOf(permission), 1)
                return checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Ok", "Permission is granted")
            return true
        }
    }

    val isStoragePermissionGranted: Boolean
        get() = isPermissionGranted(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    fun resetClicked(view: View) {
        timer.reset(true)
        try {
            if (isStoragePermissionGranted) {
                val sdCard = Environment.getExternalStorageDirectory()
                val dir = File(sdCard.absolutePath + "/LiveSplit")
                dir.mkdirs()
                val file = File(dir, "splits.lss")
                Log.d("SplitsPath", file.toString())
                file.createNewFile()
                val f = FileOutputStream(file, false)
                f.write(timer.run!!.saveAsLss().toByteArray(Charset.forName("UTF-8")))
            }
        } catch (e: IOException) {
            Log.d("D", e.toString())
        }

    }

    fun undoClicked(view: View) {
        timer.undoSplit()
    }

    fun skipClicked(view: View) {
        timer.skipSplit()
    }

    fun pauseClicked(view: View) {
        timer.pause()
    }

    companion object {

        init {
            System.loadLibrary("native-lib")
        }

        lateinit private var timer: Timer
        private val components = ArrayList<IComponent>()
        var INTERVAL = (1000 / 30).toLong()
        var runHandler = Handler()
    }
}
