package com.example.samplelifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SampleLifeCycle", "onCreate() called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }

    override fun onStart() {
        Log.i("SampleLifeCycle", "Sub onStart() called.")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("SampleLifeCycle", "Sub onRestart() called.")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("SampleLifeCycle", "Sub onResume() called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("SampleLifeCycle", "Sub onPause() called.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("SampleLifeCycle", "Sub onStop() called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("SampleLifeCycle", "Sub onDestroy() called.")
        super.onDestroy()
    }

    fun onButtonClick(view: View) {
        Log.i("SampleLifeCycle", "Sub onButtonClick() called.")
        finish()
    }

}
