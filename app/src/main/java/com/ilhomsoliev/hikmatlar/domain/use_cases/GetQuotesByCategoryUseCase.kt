package com.ilhomsoliev.hikmatlar.domain.use_cases

import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetQuotesByCategoryUseCase @Inject constructor(
    private val repository: QuoteRepository
){
    operator fun invoke(category:String): Flow<List<Quote>> {
        return repository.getQuotesByCategory(category).map { quotes ->
            quotes.sortedBy { it.category}
        }
    }
}