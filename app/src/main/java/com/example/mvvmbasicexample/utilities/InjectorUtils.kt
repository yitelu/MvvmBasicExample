package com.example.mvvmbasicexample.utilities

import com.example.mvvmbasicexample.data.FakeDatabase
import com.example.mvvmbasicexample.data.QuoteRepository
import com.example.mvvmbasicexample.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)

        return QuotesViewModelFactory(quoteRepository)

    }
}