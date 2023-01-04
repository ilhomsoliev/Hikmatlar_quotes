package com.ilhomsoliev.hikmatlar.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "citaty")
data class Quote (
    val citaty:String? = "",
    @PrimaryKey
    val id:Int,
    val category:String?= "",

    val author:String?= "",
)