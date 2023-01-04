package com.ilhomsoliev.hikmatlar.data.repository

import com.ilhomsoliev.hikmatlar.data.data_source.QuoteDao
import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow

class QuoteRepositoryImpl(
    private val dao:QuoteDao
): QuoteRepository {

    override fun getQuotes(): Flow<List<Quote>> = dao.getQuotes()
    override fun getQuotesByCategory(category: String): Flow<List<Quote>> = dao.getQuotesByCategory(category)

    override fun getQuotesByAuthor(author: String): Flow<List<Quote>> = dao.getQuotesByAuthor(author)

    override suspend fun getRandomQuote(): Quote = dao.getRandomQuote()
}