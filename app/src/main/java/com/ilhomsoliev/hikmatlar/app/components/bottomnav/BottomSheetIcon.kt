package com.ilhomsoliev.hikmatlar.app.components.bottomnav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun BottomSheetIcon(
    icon:ImageVector,
    background: Color = Color.Transparent,
    onClick:()->Unit,
    contentColor:Color=Color.White,
    title:String="",
    selected:Boolean=false
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier.size(34.dp),
                imageVector = icon,
                contentDescription = "icon",
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = title,
                    color = contentColor
                )
            }
        }
    }
}