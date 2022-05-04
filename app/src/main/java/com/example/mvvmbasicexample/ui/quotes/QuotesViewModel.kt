package com.example.mvvmbasicexample.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmbasicexample.data.Quote
import com.example.mvvmbasicexample.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)


}