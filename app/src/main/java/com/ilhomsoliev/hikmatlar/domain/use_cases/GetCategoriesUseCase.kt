package com.ilhomsoliev.hikmatlar.domain.use_cases

import android.util.Log
import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: QuoteRepository
){
     operator fun invoke(): Flow<List<String>> {
        return repository.getQuotes().map { quotes ->
            Log.d("Hello", "$quotes HERE")
            quotes.map { it.category!! }.distinct().sortedBy { it }
        }
    }
}