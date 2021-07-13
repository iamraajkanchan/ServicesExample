package com.example.servicesexample

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.lang.Exception

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is stopping ")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntentService", "Service is running... ")
                Thread.sleep(1000)
            }
        } catch (exception: InterruptedException) {
            println(exception.message)
            Thread.currentThread().interrupt(   )
        }
    }
}