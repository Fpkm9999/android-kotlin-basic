package com.example.android_kotlin_basic

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_FileStream01 : AppCompatActivity() {
    private lateinit var btnWrite: Button
    private lateinit var btnRead: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filestream01)

        val btnWrite = findViewById<Button>(R.id.btnWrite)
        val btnRead = findViewById<Button>(R.id.btnRead)

        // MODE_PRIVATE : 혼자만 사용하는 모드
        btnWrite.setOnClickListener {
            val outPutStream = openFileOutput("file.txt", Context.MODE_PRIVATE) // MODE_PRIVATE : 생성한 앱에서만 사용 가능
            val string = "파일 처리 테스트"
            outPutStream.write(string.toByteArray())
            outPutStream.close()
            Toast.makeText(applicationContext, "file.txt가 생성됨", Toast.LENGTH_SHORT).show()
        }
        btnRead.setOnClickListener {
            try {
                val inputStream = openFileInput("file.txt")
                val txt = ByteArray(30)
                inputStream.read(txt)
                val string = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext,string,Toast.LENGTH_SHORT).show()
            } catch (e : Exception) {
                Toast.makeText(applicationContext,"파일 없음",Toast.LENGTH_SHORT).show()
            }
        }

    }
}