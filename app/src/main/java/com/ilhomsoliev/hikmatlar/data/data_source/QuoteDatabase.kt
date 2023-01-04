package com.ilhomsoliev.hikmatlar.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ilhomsoliev.hikmatlar.domain.model.Quote

@Database(
    entities = [Quote::class],
    version = 6,
)
abstract class QuoteDatabase: RoomDatabase() {

    abstract val quoteDao:QuoteDao

}