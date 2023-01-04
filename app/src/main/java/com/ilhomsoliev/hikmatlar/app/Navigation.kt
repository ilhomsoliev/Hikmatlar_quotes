package com.ilhomsoliev.hikmatlar.app

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ilhomsoliev.hikmatlar.app.components.bottomnav.BottomBar
import com.ilhomsoliev.hikmatlar.core.Constants
import com.ilhomsoliev.hikmatlar.presentation.authors.AuthorsScreen
import com.ilhomsoliev.hikmatlar.presentation.categories.CategoriesScreen
import com.ilhomsoliev.hikmatlar.presentation.home.HomeScreen
import com.ilhomsoliev.hikmatlar.presentation.information.InformationScreen
import com.ilhomsoliev.hikmatlar.core.Screens
import com.ilhomsoliev.hikmatlar.presentation.quoteDetails.QuoteDetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    var isCreateLabelDialogActive by remember { mutableStateOf(false) }

    Scaffold(scaffoldState = scaffoldState,
        bottomBar = {
            if(currentScreen != Screens.QuoteDetailsScreen.route) {
                BottomBar(navController = navController)
            }
        }) {
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Screens.HomeScreen.route
        ) {
            composable(route = Screens.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Screens.AuthorsScreen.route) {
                AuthorsScreen(
                    openQuoteDetails = { authorName ->
                        navController.navigate(
                            Screens.QuoteDetailsScreen.route.replace(
                                "{${Constants.REQUEST_ID_ARG}}",
                                authorName
                            ).replace(
                                "{${Constants.TYPE_ID_ARG}}",
                                Constants.AUTHOR_TYPE
                            )
                        )
                    }
                )
            }
            composable(route = Screens.CategoriesScreen.route) {
                CategoriesScreen(openQuoteDetails = { categoryName ->
                    navController.navigate(
                        Screens.QuoteDetailsScreen.route.replace(
                            "{${Constants.REQUEST_ID_ARG}}",
                            categoryName
                        ).replace(
                            "{${Constants.TYPE_ID_ARG}}",
                            Constants.CATEGORY_TYPE
                        )
                    )
                })
            }
            composable(route = Screens.InformationScreen.route) {
                InformationScreen()
            }
            composable(
                route = Screens.QuoteDetailsScreen.route,
                arguments = listOf(navArgument(Constants.REQUEST_ID_ARG) {
                    type = NavType.StringType
                }, navArgument(Constants.TYPE_ID_ARG) {
                    type = NavType.StringType
                })
            ) {
                QuoteDetailsScreen(
                    request = it.arguments?.getString(Constants.REQUEST_ID_ARG) ?: "",
                    type = it.arguments?.getString(Constants.TYPE_ID_ARG) ?: "",
                    onHomeClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
