package com.ilhomsoliev.hikmatlar.presentation.quoteDetails

import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.domain.use_cases.GetQuotesByAuthorUseCase
import com.ilhomsoliev.hikmatlar.domain.use_cases.GetQuotesByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class QuoteDetailsScreenViewModel @Inject constructor(
    private val getQuotesByAuthorUseCase: GetQuotesByAuthorUseCase,
    private val getQuotesByCategoryUseCase: GetQuotesByCategoryUseCase
) :ViewModel(){
    var quotes = mutableStateListOf<Quote>()
    var currentQuoteIndex = mutableStateOf(-1)

    fun getQuotesByCategory(category:String){
        getQuotesByCategoryUseCase(category).onEach {
            quotes.addAll(it.map { it })
            currentQuoteIndex.value = 0
        }.launchIn(viewModelScope)
    }
    fun getQuotesByAuthor(author:String){
        getQuotesByAuthorUseCase(author).onEach {
            quotes.addAll(it.map { it })
            currentQuoteIndex.value = 0
        }.launchIn(viewModelScope)
    }
    fun nextQuote(){
        if(currentQuoteIndex.value + 1 < quotes.size){
            currentQuoteIndex.value = currentQuoteIndex.value + 1
        }
    }
    fun prevQuote(){
        if(currentQuoteIndex.value - 1 >= 0){
            currentQuoteIndex.value = currentQuoteIndex.value - 1
        }
    }
}