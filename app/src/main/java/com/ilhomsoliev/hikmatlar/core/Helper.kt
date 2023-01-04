package com.ilhomsoliev.hikmatlar.core

import androidx.compose.ui.graphics.Color
import java.util.*

object Helper {
    fun getRandomColor(): Color {
        val rnd = Random()
        return colors[rnd.nextInt(colors.size)]
    }

    fun getColorByIndex(id: Int): Color = colors[id % colors.size]

    val colors = listOf<Color>(Color(0xFF2D9CDB),
    Color(0xFF6FCF97),
    Color(0xFF56CCF2),
    Color(0xFFF2C94C),
    Color(0xFFBB6BD9),
    Color(0xFFEB5757),
    Color(0xFFBDBDBD),
    Color(0xFFF2994A),
    )
}