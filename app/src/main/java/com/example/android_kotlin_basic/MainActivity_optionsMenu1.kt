package com.example.android_kotlin_basic

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity_optionsMenu1 : AppCompatActivity() {

    private lateinit var baseLayout: LinearLayout
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.optionsmenu1)

        title = "배경색 바꾸기"

        baseLayout = findViewById(R.id.baseLayout)
        button1 = findViewById(R.id.button1)


    }

    // 오버라이딩
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
        when (item.itemId){
            R.id.itemRed -> {
                baseLayout.setBackgroundColor(Color.RED)
            }
            R.id.itemGreen -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            R.id.itemBlue -> {
                baseLayout.setBackgroundColor(Color.BLUE)
            }
            R.id.subRotate -> {
                button1.rotation += 45f
            }
            R.id.subSize -> {
                button1.scaleX  += 2f
            }
        }
        return super.onOptionsItemSelected(item)
    }

}