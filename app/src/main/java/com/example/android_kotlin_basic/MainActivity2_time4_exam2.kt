package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class MainActivity2_time4_exam2 : AppCompatActivity() {

    // 전역 변수 선언
    // 12개의 위젯에 대응할 위젯 변수 12개
    // 캘린더 뷰에서 선택할 연, 월,일에 해당하는 변수
    private lateinit var chronometer1: Chronometer

    //    private lateinit var btnStart: Button
//    private lateinit var btnEnd: Button

    private lateinit var rdoCal: RadioButton
    private lateinit var rdoTime: RadioButton

    private lateinit var dataPicker1: DatePicker

    //    private lateinit var calendarView1: CalendarView
    private lateinit var timePicker1: TimePicker

    private lateinit var tvYear: TextView
    private lateinit var tvMonth: TextView
    private lateinit var tvDay: TextView
    private lateinit var tvHour: TextView
    private lateinit var tvMinute: TextView

    var selectYear: Int = 0
    var selectMonth: Int = 0
    var selectDay: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lnearlayout_time4_exam2)

        title = "시간 예약"

        // 버튼
//        btnStart = findViewById(R.id.btnStart)
//        btnEnd = findViewById(R.id.btnEnd)

        // 크로노미터
        chronometer1 = findViewById(R.id.chronometer1)

        // 라디오버튼 2개
        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)

        // FrameLayout의 2개 위젯
        timePicker1 = findViewById(R.id.timePicker1)
//        calendarView1 = findViewById(R.id.calendarView1)
        dataPicker1 = findViewById(R.id.dataPicker1)

        // 텍스트 뷰 중에서 연, 월, 일, 시, 분 숫자
        tvYear = findViewById(R.id.tvYear)
        tvMonth = findViewById(R.id.tvMonth)
        tvDay = findViewById(R.id.tvDay)
        tvHour = findViewById(R.id.tvHour)
        tvMinute = findViewById(R.id.tvMinute)

        fun init(){
            rdoCal.isChecked = false
            rdoTime.isChecked = false
            rdoCal.visibility = View.INVISIBLE
            rdoTime.visibility = View.INVISIBLE
            timePicker1.visibility = View.INVISIBLE
            dataPicker1.visibility = View.INVISIBLE
        }

        init()

//        // 처음에 2개는 안보이게 설정
//        timePicker1.visibility = View.INVISIBLE
////        calendarView1.visibility = View.INVISIBLE
//        dataPicker1.visibility = View.INVISIBLE

        class Listener : View.OnClickListener{
            override fun onClick(v: View?) {
                timePicker1.visibility = View.INVISIBLE
                dataPicker1.visibility = View.VISIBLE
            }
        }
        rdoCal.setOnClickListener(Listener())
        // 위와 아래의 코드결과는 동일하다 위코드를 람다식으로 줄인게 아래임
//        rdoCal.setOnClickListener {
//            timePicker1.visibility = View.INVISIBLE
////            calendarView1.visibility = View.VISIBLE
//            dataPicker1.visibility = View.VISIBLE
//        }
        rdoTime.setOnClickListener {
            timePicker1.visibility = View.VISIBLE
//            calendarView1.visibility = View.INVISIBLE
            dataPicker1.visibility = View.INVISIBLE

        }

        // 타이머 설정
//        btnStart.setOnClickListener {
//            chronometer1.base = SystemClock.elapsedRealtime()
//            chronometer1.start()
//            chronometer1.setTextColor(Color.RED)
//        }
        chronometer1.setOnClickListener {
            chronometer1.base = SystemClock.elapsedRealtime()
            chronometer1.start()
            chronometer1.setTextColor(Color.RED)
            rdoCal.visibility = View.VISIBLE
            rdoTime.visibility = View.VISIBLE

        }

        tvYear.setOnLongClickListener {
            chronometer1.stop()
            chronometer1.setTextColor(Color.BLUE)

            tvYear.text = selectYear.toString()
            tvMonth.text = selectMonth.toString()
            tvDay.text = selectDay.toString()

            tvHour.text = timePicker1.currentHour.toString()
            tvMinute.text = timePicker1.currentMinute.toString()

            init()
            return@setOnLongClickListener false
        }

//        tvYear.setOnClickListener {
////            chronometer1.stop()
////            chronometer1.setTextColor(Color.BLUE)
////
////            tvYear.text = selectYear.toString()
////            tvMonth.text = selectMonth.toString()
////            tvDay.text = selectDay.toString()
////
////            tvHour.text = timePicker1.currentHour.toString()
////            tvMinute.text = timePicker1.currentMinute.toString()
////
//////            init()
////            rdoCal.visibility = View.INVISIBLE
////            rdoTime.visibility = View.INVISIBLE
//////
//////
////            timePicker1.visibility = View.INVISIBLE
//////            calendarView1.visibility = View.INVISIBLE
////            dataPicker1.visibility = View.INVISIBLE
//        }


        // 버튼을 클릭하면 날짜, 시간을 가져온다.
//        btnEnd.setOnClickListener {
//            chronometer1.stop()
//            chronometer1.setTextColor(Color.BLUE)
//
//            tvYear.text = selectYear.toString()
//            tvMonth.text = selectMonth.toString()
//            tvDay.text = selectDay.toString()
//
//            tvHour.text = timePicker1.currentHour.toString()
//            tvMinute.text = timePicker1.currentMinute.toString()
//
//        }
//        calendarView1.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            selectYear = year
//            selectMonth = month + 1
//            selectDay = dayOfMonth
//        }

        dataPicker1.setOnDateChangedListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }


    }
}