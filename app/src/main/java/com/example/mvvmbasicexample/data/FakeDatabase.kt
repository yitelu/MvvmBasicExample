package com.example.mvvmbasicexample.data

class FakeDatabase private constructor(){

    var quoteDao = FakeQuoteDao()
        private set

    // this is the sample of Singleton
    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this){
            instance ?: FakeDatabase().also { instance = it }
        }
    }

}