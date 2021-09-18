package com.example.broadcasttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_success.*

class SuccessActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        forceOffline.setOnClickListener {
            val intent=Intent("com.example.broadcasttest.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }
}