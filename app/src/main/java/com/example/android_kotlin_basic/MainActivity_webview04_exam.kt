package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity_webview04_exam : AppCompatActivity() {

    // 전역 변수 선언
    lateinit var webView: WebView

    lateinit var textview1: TextView
    lateinit var textview2: TextView
    lateinit var textview3: TextView
    lateinit var textview4: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview04_exam)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.drawable.web)


        webView = findViewById(R.id.webView)

        textview1 = findViewById(R.id.textview1)
        textview2 = findViewById(R.id.textview2)
        textview3 = findViewById(R.id.textview3)
        textview4 = findViewById(R.id.textview4)

        webView.webViewClient = myWebViewClient()


        val webSet = webView.settings
        webSet.builtInZoomControls = true
        webSet.javaScriptEnabled = true
        webView.loadUrl("https://www.ediya.com/")

        textview1.setOnClickListener {
            webView.loadUrl("https://www.ediya.com/")
        }

        textview2.setOnClickListener {
            webView.loadUrl("https://ediya.recruiter.co.kr/appsite/company/index/")
        }
        textview3.setOnClickListener {

            webView.loadUrl("https://www.ediya.com/contents/customer_intro.html")
        }
        textview4.setOnClickListener {

            webView.loadUrl("https://www.ediya.com/contents/notice.html")
        }


    }

    // 내부 클래스 로 작업
    // webViewClinet 를 상속 받는 MyWebViewClinet 클래스를 정의
    class myWebViewClient : WebViewClient() {


        override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
            return super.shouldInterceptRequest(view, url)
        }
    }
}
