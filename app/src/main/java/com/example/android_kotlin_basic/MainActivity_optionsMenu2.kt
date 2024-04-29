package com.example.android_kotlin_basic

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity_optionsMenu2 : AppCompatActivity() {

    private lateinit var baseLayout: LinearLayout
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.optionsmenu1)

        title = "배경색 바꾸기"
        baseLayout = findViewById(R.id.baseLayout)
        button1 = findViewById(R.id.button1)


    }

    // 25번 줄 까지는 기존 코드와 동일


    // 오버 라이딩
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu?.add(0, 1, 0, "배경색 (빨강)")
        menu?.add(0, 2, 0, "배경색 (초록)")
        menu?.add(0, 3, 0, "배경색 (파랑)")

        val subMenu = menu?.addSubMenu("버튼 변경 >> ")
        subMenu?.add(0,4,0,"버튼 45도 회전")
        subMenu?.add(0,5,0,"버튼 2배 확대")
        return true
    }

    /*
        옵션 메뉴(Options Menu) 에서 특정 `Menu Item`을 선택 하였을 때 호출 되는 함수.
        > 매개 변수로 선택된 `MenuItem`의 객체가 넘어 온다.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                baseLayout.setBackgroundColor(Color.RED)
            }

            2 -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }

            3 -> {
                baseLayout.setBackgroundColor(Color.BLUE)
            }

            4 -> {
                button1.rotation += 45f
            }

            5 -> {
                button1.scaleX += 2f
            }
        }
        return super.onOptionsItemSelected(item)
    }

}