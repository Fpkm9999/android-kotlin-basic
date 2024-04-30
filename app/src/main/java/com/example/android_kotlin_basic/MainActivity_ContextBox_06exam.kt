package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity_ContextBox_06exam : AppCompatActivity() {
    private lateinit var button: Button // 로그인 버튼

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText

    private lateinit var dialogView: View
    private val userID = "admin"
    private val userPassWd = "1111"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contextbox3_exam)

        title = "로그인 정보 입력"

        button = findViewById(R.id.button)


        // button 변수를 클릭 했을 때 리스너를 작성.
        button.setOnClickListener {

            // 사용자 아이디 비밀번호 입력
            dialogView = View.inflate(this@MainActivity_ContextBox_06exam, R.layout.dialog2, null)

            val dialog = AlertDialog.Builder(this@MainActivity_ContextBox_06exam)
            dialog.setTitle("사용자 정보 입력")
            dialog.setIcon(R.drawable.ic_menu_allfriends)
            dialog.setView(dialogView)
            // 포지티브 버튼을 클릭
            dialog.setPositiveButton("확인") { _, _ ->

                editText1 = dialogView.findViewById(R.id.editText1)
                editText2 = dialogView.findViewById(R.id.editText2)

                if (editText1.text.toString() == userID && editText2.text.toString() == userPassWd) {
                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
            dialog.show()

        }
    }


}