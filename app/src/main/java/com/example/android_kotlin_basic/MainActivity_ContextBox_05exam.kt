package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity_ContextBox_05exam : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var button: Button

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText

    private lateinit var toastText1: TextView
    private lateinit var dialogView: View
    private lateinit var toastView: View

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contextbox2)

        title = "사용자 정보 입력"

        textViewName = findViewById(R.id.textViewName)
        textViewEmail = findViewById(R.id.textViewEmail)
        button = findViewById(R.id.button)


        // button 변수를 클릭 했을 때 리스너를 작성.
        button.setOnClickListener {
            dialogView = View.inflate(this@MainActivity_ContextBox_05exam, R.layout.dialog1, null)

            val dialog = AlertDialog.Builder(this@MainActivity_ContextBox_05exam)
            dialog.setTitle("사용자 정보 입력")
            dialog.setIcon(R.drawable.ic_menu_allfriends)
            dialog.setView(dialogView)
            dialog.setPositiveButton("확인") { dlog, which ->
                editText1 = dialogView.findViewById(R.id.editText1)
                editText2 = dialogView.findViewById(R.id.editText2)

                textViewName.text = editText1.text.toString()
                textViewEmail.text = editText2.text.toString()
            }

            dialog.setNegativeButton("취소") { dlog, which ->
                val toast = Toast(this@MainActivity_ContextBox_05exam)
                toastView = View.inflate(this@MainActivity_ContextBox_05exam, R.layout.toast1, null)
                toastText1 = toastView.findViewById<TextView>(R.id.toastText1)
                toastText1.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }
            dialog.show()

        }
    }
}