package com.example.android_kotlin_basic

import android.os.Bundle
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity_webview03_exam : AppCompatActivity() {

    // 전역 변수 선언
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_03_exam_only)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.drawable.web)


        webView = findViewById(R.id.webView)
        webView.webViewClient = myWebViewClient()



        val webSet = webView.settings
        webSet.builtInZoomControls = true
        webSet.javaScriptEnabled = true
        webView.loadUrl("https://www.starbucks.co.kr:7643/index.do")

    }

    // 내부 클래스 로 작업
    // webViewClinet 를 상속 받는 MyWebViewClinet 클래스를 정의
    class myWebViewClient : WebViewClient() {


        override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
            return super.shouldInterceptRequest(view, url)
        }
    }
}
