package com.example.mvvmbasicexample.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmbasicexample.R
import com.example.mvvmbasicexample.data.Quote
import com.example.mvvmbasicexample.utilities.InjectorUtils

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initiallizeUi()
    }

    private fun initiallizeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        val tvQuotes = findViewById<TextView>(R.id.textView_quotes)
        val btnAddQuote = findViewById<Button>(R.id.button_add_quote)
        val etQuote = findViewById<EditText>(R.id.editText_quote)
        val etAuthor = findViewById<EditText>(R.id.editText_author)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            tvQuotes.text = stringBuilder.toString()
        })

        btnAddQuote.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())

            //add it to the database
            viewModel.addQuote(quote)

            // clear the edit text on quote and author
            etQuote.setText("")
            etAuthor.setText("")
        }
    }
}