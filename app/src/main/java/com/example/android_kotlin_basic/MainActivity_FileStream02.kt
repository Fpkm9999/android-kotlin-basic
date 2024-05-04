package com.example.android_kotlin_basic

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_FileStream02 : AppCompatActivity() {
    private lateinit var btnWrite: Button
    private lateinit var editRaw: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filestream02)

        val btnRead = findViewById<Button>(R.id.btnRead)
        val editRaw = findViewById<EditText>(R.id.editRaw)

        btnRead.setOnClickListener {
            val inputStream = resources.openRawResource(R.raw.test)
            val txt = ByteArray(inputStream.available())
            inputStream.read(txt)

            editRaw.setText(txt.toString(Charsets.UTF_8))
            inputStream.close()
        }


    }
}