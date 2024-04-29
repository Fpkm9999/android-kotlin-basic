package com.example.android_kotlin_basic

import android.app.TabActivity
import android.os.Bundle

class MainActivity_tabhost02 : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabhost02_exam)


        /* tab host */
        val tabHost = this.tabHost

        val windows11 = tabHost.newTabSpec("windows").setIndicator("윈도우")
        windows11.setContent(R.id.imageView1)
        tabHost.addTab(windows11)

        val ubuntu = tabHost.newTabSpec("ubuntu").setIndicator("우분투")
        ubuntu.setContent(R.id.imageView2)
        tabHost.addTab(ubuntu)

        val android = tabHost.newTabSpec("android").setIndicator("안드로이드")
        android.setContent(R.id.imageView3)
        tabHost.addTab(android)

        val android14 = tabHost.newTabSpec("android14").setIndicator("안드14")
        android14.setContent(R.id.imageView4)
        tabHost.addTab(android14)


        tabHost.currentTab = 0

    }
}