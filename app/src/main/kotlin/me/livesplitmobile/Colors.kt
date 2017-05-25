package me.livesplitmobile

/**
 * Created by MidKnight on 5/14/2017.
 */

object Colors {
    fun colorFromString(colorName: String): Int {
        when (colorName) {
            "AheadGainingTime" -> return 0xFF00CC4B.toInt()
            "AheadLosingTime" -> return 0xFF5CD689.toInt()
            "BehindGainingTime" -> return 0xFFD65C5C.toInt()
            "BehindLosingTime" -> return 0xFFCC0000.toInt()
            "BestSegment" -> return 0xFFFFD500.toInt()
            "NotRunning" -> return 0xFF999999.toInt()
            "Paused" -> return 0xFF666666.toInt()
            "PersonalBest" -> return 0xFF4DA6FF.toInt()
            else -> return 0xFFEEEEEE.toInt()
        }
    }
}
