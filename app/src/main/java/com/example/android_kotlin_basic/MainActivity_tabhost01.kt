package com.example.android_kotlin_basic

import android.app.TabActivity
import android.os.Bundle

class MainActivity_tabhost01 : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabhost01)

        /* tab host */
        val tabHost = this.tabHost

        val tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
        tabSpecSong.setContent(R.id.tabSong)
        tabHost.addTab(tabSpecSong)

        val tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
        tabSpecArtist.setContent(R.id.tabArtist)
        tabHost.addTab(tabSpecArtist)

        val tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
        tabSpecAlbum.setContent(R.id.tabAlbum)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0

    }
}