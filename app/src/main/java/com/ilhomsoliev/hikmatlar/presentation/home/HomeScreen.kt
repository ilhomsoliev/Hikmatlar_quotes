package com.ilhomsoliev.hikmatlar.presentation.home

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilhomsoliev.hikmatlar.presentation.components.QuoteContent

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val homeState by viewModel.homeState
    if(homeState.isLoading){
        CircularProgressIndicator()
    }
    homeState.quote?.let {
        QuoteContent(category = it.category?:"asd",
            content = it.citaty?:"", author = it.author?:"")
    }
}