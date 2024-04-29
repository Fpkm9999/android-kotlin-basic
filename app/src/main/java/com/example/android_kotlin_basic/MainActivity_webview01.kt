package com.example.android_kotlin_basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity_webview01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview01)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.drawable.web)
    }
}