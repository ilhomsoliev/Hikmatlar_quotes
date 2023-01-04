package com.ilhomsoliev.hikmatlar.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.hikmatlar.domain.use_cases.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
):ViewModel() {

    val homeState = mutableStateOf(HomeState())

    init {
        getRandomQuote()
    }

    private fun getRandomQuote(){
        viewModelScope.launch {
            homeState.value = homeState.value.copy(quote = getRandomQuoteUseCase(), isLoading = false)
        }
    }
}