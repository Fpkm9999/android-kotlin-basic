package com.example.android_kotlin_basic

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_webview02 : AppCompatActivity() {

    // 전역 변수 선언
    private lateinit var editURL: EditText
    private lateinit var btnGo: Button
    private lateinit var btnback: Button
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview02_exam)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.drawable.web)

        editURL = findViewById(R.id.editURL)
        btnGo = findViewById(R.id.btnGo)
        btnback = findViewById(R.id.btnBack)
        webView = findViewById(R.id.webView)

        webView.webViewClient = myWebViewClient()

        val webSet = webView.settings
        webSet.builtInZoomControls = true
        webSet.javaScriptEnabled = true

        btnGo.setOnClickListener {
            Toast.makeText(applicationContext, editURL.text.toString(), Toast.LENGTH_SHORT).show()
            webView.loadUrl(editURL.text.toString())
        }

        btnback.setOnClickListener {
            webView.goBack()
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
