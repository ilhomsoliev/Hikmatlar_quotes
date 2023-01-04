package com.ilhomsoliev.hikmatlar.presentation.authors

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.hikmatlar.domain.use_cases.GetAuthorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthorsScreenViewModel@Inject constructor(
    private val getAuthorsUseCase: GetAuthorsUseCase,
): ViewModel() {
    var authors = mutableStateListOf<String>()
    init {
        getCategories()
    }
    private fun getCategories(){
        getAuthorsUseCase().onEach {
            authors.addAll(it.map { it })
        }.launchIn(viewModelScope)
    }
}