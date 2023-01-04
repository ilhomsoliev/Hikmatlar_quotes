package com.ilhomsoliev.hikmatlar.presentation.home

import com.ilhomsoliev.hikmatlar.domain.model.Quote

data class HomeState(
    val quote: Quote?=null,
    val isLoading:Boolean = true
)