package com.example.android_kotlin_basic

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity_ContextBox_03 : AppCompatActivity() {
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contextbox1)

        button = findViewById(R.id.button)

        /*
            선택을 해도 닫히지 않도록 하기
         */
        button.setOnClickListener {
            val versionArray = arrayOf("오레오","파이","큐(10)")
            val dlg = AlertDialog.Builder(this@MainActivity_ContextBox_03)
            dlg.setTitle(/* title = */ "좋아하는 버전은?.")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setSingleChoiceItems(versionArray,0) {dialog,which ->
                button.text = versionArray[which]
            }
            dlg.setPositiveButton("확인",null)
            dlg.show()

        }
    }
}