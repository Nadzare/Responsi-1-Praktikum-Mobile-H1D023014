package com.unsoed.responsi1mobileh1d023014.utils

import android.graphics.Color

object PositionColor {
    fun getColorForPosition(position: String?): Int {
        return when (position) {
            "Goalkeeper" -> Color.parseColor("#FFD600")
            "Defence", "Defender", "Centre-Back", "Left-Back" -> Color.parseColor("#1E88E5")
            "Midfield", "Midfielder", "Central Midfield", "Right Winger", "Left Winger", "Right Midfield" -> Color.parseColor("#43A047")
            "Offence", "Forward", "Centre-Forward" -> Color.parseColor("#E53935")
            else -> Color.parseColor("#BDBDBD")
        }
    }
}
