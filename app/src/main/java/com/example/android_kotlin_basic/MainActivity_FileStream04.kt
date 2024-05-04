package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class MainActivity_FileStream04 : AppCompatActivity() {

    lateinit var datePicker: DatePicker
    lateinit var editDiary: EditText
    lateinit var btnWrite: Button
    lateinit var fileName: String

    lateinit var savePath: String // 저장 경로
    var isFlag = false // 디렉토리 생성을 저장

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filestream04_exam)


        title = "간단 일기장"
        /**
         * 외장 스토리지 권환 허용
         */
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )


        datePicker = findViewById(R.id.datePicker)
        editDiary = findViewById(R.id.editDiary)
        btnWrite = findViewById(R.id.btnWrite)

        val calendar = Calendar.getInstance()
        val calendarYear = calendar.get(Calendar.YEAR)
        val calendarMonth = calendar.get(Calendar.MONTH)
        val calendarDay = calendar.get(Calendar.DAY_OF_MONTH)

        // 외부 저장경로
        savePath = Environment.getExternalStorageDirectory().absolutePath + "/MyDiary"

        datePicker.init( // datePicker 객체 초기화
            calendarYear,
            calendarMonth,
            calendarDay,
            DatePicker.OnDateChangedListener() { datePicker: DatePicker, year: Int, month: Int, day: Int ->
                makeDir()
                fileName = "${year}_${month + 1}_${day}.txt"

                val string = readDiary(fileName) // 해당날짜에 해당되는 일기 파일을 읽기

                Log.d("MyAppTag", fileName);

//                Toast.makeText(applicationContext, fileName, Toast.LENGTH_SHORT).show()

                editDiary.setText(string) // 에디트텍스트에 일기 내용을 출력

                Log.d("MyAppTag", editDiary.toString());

                btnWrite.isEnabled = true // 버튼 활성화
            })

//

    btnWrite.setOnClickListener {
        val outputStream = FileOutputStream("$savePath/$fileName")
        val string1 = editDiary.text.toString()
        // 테스트
//            Toast.makeText(applicationContext, string1, Toast.LENGTH_SHORT).show()
        Log.d("MyAppTag", string1)

        outputStream.write(string1.toByteArray())
        outputStream.close()
        Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
    }


}

@SuppressLint("SetTextI18n")
private fun readDiary(fileName: String): String? {
    var diaryStr: String? = null
    val inputStream: FileInputStream

    try {
        inputStream = FileInputStream("$savePath/$fileName")

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

private fun makeDir() {
    if (!isFlag) {
        // 저장 경로 생성
        val myDir = File(savePath)
        myDir.mkdir()
        isFlag = true
    }
}
}