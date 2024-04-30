package com.example.android_kotlin_basic

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity_ContextBox_02 : AppCompatActivity() {
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contextbox1)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            val versionArray = arrayOf("오레오","파이","큐(10)")
            val dlg = AlertDialog.Builder(this@MainActivity_ContextBox_02)
            dlg.setTitle("좋아하는 버전은?.")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setItems(versionArray) {dialog,which ->
                button.text = versionArray[which]
            }
            dlg.setPositiveButton("확인",null)
            dlg.show()

        }
    }
}