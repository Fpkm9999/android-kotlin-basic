package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity

class MainActivity_viewflipper02_exam : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewflipper02_exam)

        title = "뷰플리퍼 2"

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val viewFlipper1 = findViewById<ViewFlipper>(R.id.viewFlipper1)

        viewFlipper1.flipInterval = 1000

        btnStart.setOnClickListener {
            viewFlipper1.startFlipping()
        }
        btnStop.setOnClickListener {
            viewFlipper1.stopFlipping()

        }

    }
}