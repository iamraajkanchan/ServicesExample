package com.example.servicesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var btStop: Button? = null
    private var btStart: Button? = null
    private var tvLabel: TextView? = null
    private var edDataString: EditText? = null
    private var btSendData: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btStart?.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tvLabel?.text = "Service Running"
            }
        }
        btStop?.setOnClickListener {
            MyIntentService.stopService()
            tvLabel?.setText("Service Stopped")
        }
    }

    init {
        btStop = findViewById(R.id.bt_stop)
        btStart = findViewById(R.id.bt_start)
        tvLabel = findViewById(R.id.tv_label)
        edDataString = findViewById(R.id.ed_dataString)
        btSendData = findViewById(R.id.bt_sendData)
    }
}