package com.ilhomsoliev.hikmatlar.di

import android.app.Application
import androidx.room.Room
import com.ilhomsoliev.hikmatlar.data.data_source.QuoteDatabase
import com.ilhomsoliev.hikmatlar.data.repository.QuoteRepositoryImpl
import com.ilhomsoliev.hikmatlar.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): QuoteDatabase {
        return Room.databaseBuilder(
            app,
            QuoteDatabase::class.java,
            "quotes_db"
        )
            .fallbackToDestructiveMigration()
            .createFromAsset("quotes.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: QuoteDatabase): QuoteRepository {
        return QuoteRepositoryImpl(db.quoteDao)
    }

}