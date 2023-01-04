package com.ilhomsoliev.hikmatlar.core

sealed class Screens(val route: String) {
    object HomeScreen : Screens("HomeScreen")
    object AuthorsScreen : Screens("AuthorsScreen")
    object CategoriesScreen : Screens("CategoriesScreen")
    object InformationScreen : Screens("InformationScreen")
    object QuoteDetailsScreen :
        Screens("QuoteDetailsScreen/{${Constants.REQUEST_ID_ARG}}/{${Constants.TYPE_ID_ARG}}")


}