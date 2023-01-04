package com.ilhomsoliev.hikmatlar.app.components.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.ilhomsoliev.hikmatlar.R
import com.ilhomsoliev.hikmatlar.core.Screens


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {

    object Home: BottomBarScreen(
        route = Screens.HomeScreen.route,
        title = "Home",
        icon = Icons.Default.Home,
    )

    object Category: BottomBarScreen(
        route = Screens.CategoriesScreen.route,
        title = "Category",
        icon = Icons.Default.Article,
    )

    object Authors: BottomBarScreen(
        route = Screens.AuthorsScreen.route,
        title = "Authors",
        icon = Icons.Default.AccountCircle,
    )

    object Information: BottomBarScreen(
        route = Screens.InformationScreen.route,
        title = "Information",
        icon = Icons.Default.Info,
    )

}
