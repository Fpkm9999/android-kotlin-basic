package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.IOException
import kotlin.math.log

class MainActivity_FileStream03 : AppCompatActivity() {
    lateinit var datePicker: DatePicker
    lateinit var editDiary: EditText
    lateinit var btnWrite: Button
    lateinit var fileName: String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filestream03_exam)

        title = "간단 일기장"

        datePicker = findViewById(R.id.datePicker)
        editDiary = findViewById(R.id.editDiary)
        btnWrite = findViewById(R.id.btnWrite)

        val calendar = Calendar.getInstance()
        val calendarYear = calendar.get(Calendar.YEAR)
        val calendarMonth = calendar.get(Calendar.MONTH)
        val calendarDay = calendar.get(Calendar.DAY_OF_MONTH)

        btnWrite.setOnClickListener {
            val outputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            val string1 = editDiary.text.toString()
            // 테스트
//            Toast.makeText(applicationContext, string1, Toast.LENGTH_SHORT).show()
            Log.d("MyAppTag",string1)

            outputStream.write(string1.toByteArray())
            outputStream.close()
            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }


        datePicker.init( // datePicker 객체 초기화
            calendarYear,
            calendarMonth,
            calendarDay,
            DatePicker.OnDateChangedListener(){
                datePicker: DatePicker, year: Int, month: Int, day: Int ->
                fileName = "${year}_${month + 1}_${day}.txt"

                val string = readDiary(fileName) // 날짜에 해당하는 일기 파일을 읽기

                Log.d("MyAppTag", fileName);

                Toast.makeText(applicationContext, fileName, Toast.LENGTH_SHORT).show()

                editDiary.setText(string) // 에디트텍스트에 일기 내용을 출력

                Log.d("MyAppTag", editDiary.toString());

                btnWrite.isEnabled = true // 버튼 활성화
            })

    }

//    private fun readDiary(fileName: String): String {
//        return ""
//    }


    @SuppressLint("SetTextI18n")
    private fun readDiary(fileName: String): String? {
        var diaryStr: String? = null
        val inputStream: FileInputStream

        try {
            inputStream = openFileInput(fileName)
            val txt = ByteArray(inputStream.available())
            inputStream.read(txt)
            inputStream.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정하기"
        } catch (e: IOException) {
            editDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }
        return diaryStr;
    }

}