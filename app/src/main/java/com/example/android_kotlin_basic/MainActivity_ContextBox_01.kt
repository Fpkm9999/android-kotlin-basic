package com.example.android_kotlin_basic

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity_ContextBox_01 : AppCompatActivity() {
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contextbox1)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            val dlg = AlertDialog.Builder(this@MainActivity_ContextBox_01)
            dlg.setTitle("제목입니다.")
            dlg.setMessage("이곳이 내용입니다.")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setPositiveButton("확인",null)
            dlg.show()
        }
    }
}