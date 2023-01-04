package com.ilhomsoliev.hikmatlar.domain.use_cases

import androidx.compose.runtime.Composable
import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
){
    suspend operator fun invoke(): Quote {
        return repository.getRandomQuote()
    }
}