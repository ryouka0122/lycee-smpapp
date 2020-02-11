package com.example.samplelifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SampleLifeCycle", "Main onCreate() called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.i("SampleLifeCycle", "Main onStart() called.")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("SampleLifeCycle", "Main onRestart() called.")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("SampleLifeCycle", "Main onResume() called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("SampleLifeCycle", "Main onPause() called.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("SampleLifeCycle", "Main onStop() called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("SampleLifeCycle", "Main onDestroy() called.")
        super.onDestroy()
    }

    fun onButtonClick(view: View) {
        Log.i("SampleLifeCycle", "Main onButtonClick() called.")
        val intent = Intent(applicationContext, SubActivity::class.java)
        startActivity(intent)
    }

}
