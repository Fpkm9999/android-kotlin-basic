package com.example.android_kotlin_basic

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity_AutocompleteTextView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autocompletetextview_mutliautocompletetextview01)

        val items = arrayOf("CIS-뉴욕","CSI-라스베가스","CSI-마이애미","Friend","Fringe","Lost")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items)

        val auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
        auto.setAdapter(adapter)


        val multi = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView1)
        val tokenizer = MultiAutoCompleteTextView.CommaTokenizer()
        multi.setTokenizer(tokenizer)
        multi.setAdapter(adapter)

        // val items = arrayOf("CIS-뉴욕","CSI-라스베가스","CSI-마이애미","Friend","Fringe","Lost")
        // 자동 완성될 문자열을 배열로 정의
    }
}