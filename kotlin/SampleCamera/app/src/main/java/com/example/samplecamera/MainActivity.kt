package com.example.samplecamera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.opencv.android.CameraActivity

class MainActivity : CameraActivity() {

    init {
        System.loadLibrary("opencv_java4")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
