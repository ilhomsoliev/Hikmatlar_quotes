package com.ilhomsoliev.hikmatlar.data.data_source

import androidx.room.*
import com.ilhomsoliev.hikmatlar.domain.model.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {

    @Query("SELECT * FROM citaty")
     fun getQuotes():Flow<List<Quote>>

    @Query("SELECT * FROM citaty WHERE category = :category")
     fun getQuotesByCategory(category:String):Flow<List<Quote>>

    @Query("SELECT * FROM citaty WHERE author = :author")
     fun getQuotesByAuthor(author:String):Flow<List<Quote>>

    @Query("SELECT * FROM citaty ORDER BY RANDOM() LIMIT 1;")
    suspend fun getRandomQuote():Quote
}