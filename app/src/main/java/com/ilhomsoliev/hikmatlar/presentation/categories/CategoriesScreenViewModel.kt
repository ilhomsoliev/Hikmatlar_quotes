package com.ilhomsoliev.hikmatlar.presentation.categories

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.hikmatlar.domain.use_cases.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoriesScreenViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
): ViewModel() {
    var categories = mutableStateListOf<String>()
    init {
        getCategories()
    }
    private fun getCategories(){
        getCategoriesUseCase().onEach {
            categories.addAll(it.map { it })
        }.launchIn(viewModelScope)
    }
}