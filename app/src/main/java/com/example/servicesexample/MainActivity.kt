package com.example.servicesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_start.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tv_label?.text = "Service Running"
            }
        }
        bt_stop?.setOnClickListener {
            MyIntentService.stopService()
            tv_label?.text = "Service Stopped"
        }
    }
}