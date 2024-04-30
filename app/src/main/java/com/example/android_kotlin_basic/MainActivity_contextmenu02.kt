package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity_contextmenu02 : AppCompatActivity() {
    private lateinit var baseLayout: LinearLayout
    private lateinit var button1: Button
    private lateinit var button2: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contextmenu02)

        baseLayout = findViewById(R.id.baseLayout)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        registerForContextMenu(button1)
        registerForContextMenu(button2)


    }

    // 컨텍스트 메뉴를 등록한 메서드 오버라이딩
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v == button1){
            menu?.setHeaderTitle("배경색 변경")
            menuInflater.inflate(R.menu.menu3,menu)
        } else if (v == button2){
            menuInflater.inflate(R.menu.menu4,menu)
        }
    }

    // 휴대폰을 실행하면 long 클릭하면 된다.
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.itemRed -> {
                baseLayout.setBackgroundColor(Color.RED)
            }
            R.id.itemGreen -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            R.id.itemBlue -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            R.id.subRotate -> {
                button2.rotation += 45f
            }
            R.id.subSize -> {
                button2.scaleX = 2f
            }
        }
        return super.onContextItemSelected(item)
    }
}