package com.ilhomsoliev.hikmatlar.domain.use_cases

import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
){
     operator fun invoke(): Flow<List<Quote>> {
        return repository.getQuotes().map { quotes ->
            quotes.sortedBy { it.citaty}
        }
    }
}