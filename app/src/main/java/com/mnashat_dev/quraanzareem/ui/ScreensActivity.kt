package com.mnashat_dev.quraanzareem.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mnashat_dev.quraanzareem.R

class ScreensActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screens)
        supportActionBar?.hide()

    }
}