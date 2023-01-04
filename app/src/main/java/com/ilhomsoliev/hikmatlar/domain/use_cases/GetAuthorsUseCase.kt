package com.ilhomsoliev.hikmatlar.domain.use_cases

import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAuthorsUseCase @Inject constructor(
    private val repository: QuoteRepository
){
    operator fun invoke(): Flow<List<String>> {
        return repository.getQuotes().map { quotes ->
            quotes.map { it.author!!}.distinct().sortedBy { it }
        }
    }
}