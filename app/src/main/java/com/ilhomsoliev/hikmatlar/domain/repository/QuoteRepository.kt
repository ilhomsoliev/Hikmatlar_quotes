package com.ilhomsoliev.hikmatlar.domain.repository

import com.ilhomsoliev.hikmatlar.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getQuotes(): Flow<List<Quote>>
    fun getQuotesByCategory(category:String): Flow<List<Quote>>
    fun getQuotesByAuthor(author:String): Flow<List<Quote>>
    suspend fun getRandomQuote(): Quote
}