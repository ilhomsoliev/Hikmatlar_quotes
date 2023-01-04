package com.ilhomsoliev.hikmatlar.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuoteContent(
    category: String,
    content: String,
    author: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Title(
            modifier = Modifier.padding(vertical = 32.dp),
            text = category
        )
        Text(
            modifier = Modifier.padding(bottom = 24.dp),
            text = content,
            fontSize = 24.sp,
            fontWeight = FontWeight(500)
        )
        Text(
            text = "\"\"$author",
            fontSize = 24.sp,
            fontWeight = FontWeight(500)
        )
        // ADS
    }

}