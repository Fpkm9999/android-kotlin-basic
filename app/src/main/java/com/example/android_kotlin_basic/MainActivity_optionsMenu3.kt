package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity_optionsMenu3 : AppCompatActivity() {

    private lateinit var baseLayout2: LinearLayout
    private lateinit var imageView1: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.l2024_04_29_1)

        title = "배경색 바꾸기"

        baseLayout2 = findViewById(R.id.baseLayout2)
        imageView1 = findViewById(R.id.imageView1)

    }

    // 오버라이딩
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                imageView1.setImageResource(R.drawable.jeju12)
                item.isChecked = true
            }

            R.id.item2 -> {
                imageView1.setImageResource(R.drawable.jeju13)
                item.isChecked = true
            }

            R.id.item3 -> {
                imageView1.setImageResource(R.drawable.jeju10)
                item.isChecked = true

            }

            R.id.subRotate2 -> {
                imageView1.rotation += 45f
            }
        }
        return super.onOptionsItemSelected(item)
    }

}