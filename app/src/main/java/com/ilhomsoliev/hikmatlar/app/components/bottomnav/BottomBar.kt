package com.ilhomsoliev.hikmatlar.app.components.bottomnav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ilhomsoliev.hikmatlar.app.theme.Purple500

@Composable
fun BottomBar(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Category,
        BottomBarScreen.Authors,
        BottomBarScreen.Information,
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF3F3D3D))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val background =
        if (selected) Purple500.copy(alpha = 0.6f) else Color.Transparent

    val contentColor =
        if (!selected) Color(0xFFB1B1B1)else Color.White

    BottomSheetIcon(
        background = background,
        icon = screen.icon,
        title = screen.title,
        contentColor = contentColor,
        selected = selected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
}
