package com.example.servicesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val TAG = "MyService"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Use it for Intent Service
        /*bt_start.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tv_label?.text = "Service Running"
            }
        }
        bt_stop?.setOnClickListener {
            MyIntentService.stopService()
            tv_label?.text = "Service Stopped"
        }*/

        // Use it for Service
        bt_start.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tv_label.text = "Service is running"
                Log.d(TAG, "Service Started")
            }
        }

        bt_stop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tv_label.text = "Service stopped"
                Log.d(TAG, "Service Stopped")
            }
        }

        bt_sendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = ed_dataString.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}