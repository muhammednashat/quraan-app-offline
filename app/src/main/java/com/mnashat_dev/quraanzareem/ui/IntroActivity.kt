package com.mnashat_dev.quraanzareem.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mnashat_dev.quraanzareem.R
import com.mnashat_dev.quraanzareem.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_intro)

        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this@IntroActivity, ScreensActivity::class.java))
            finish()
        },3000)


    }

}

