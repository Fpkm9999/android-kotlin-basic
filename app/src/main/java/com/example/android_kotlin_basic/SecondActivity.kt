package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * ㅇ
 */
class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitypt01_second)

        val btnReturn: Button = findViewById(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish() // finish() 가 호출되면 현재 액티비티를 종료.
        }
    }
}