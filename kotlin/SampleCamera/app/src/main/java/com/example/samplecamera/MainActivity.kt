package com.example.samplecamera

import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.opencv.android.*
import org.opencv.core.Mat

class MainActivity : CameraActivity(),
        CameraBridgeViewBase.CvCameraViewListener2
{

    val TAG : String = "SampleCamera.MainActivity"

    init {
        System.loadLibrary("opencv_java4")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        javaCamera2View.visibility = View.VISIBLE

        javaCamera2View.setCvCameraViewListener(this)
    }

    override fun getCameraViewList(): MutableList<out CameraBridgeViewBase> {
        return arrayListOf(javaCamera2View)
    }

    override fun onPause() {
        super.onPause()
        javaCamera2View?.disableView()
    }


    private val loaderCallback = object: BaseLoaderCallback(this) {
        override fun onManagerConnected(status: Int) {
            when(status) {
                LoaderCallbackInterface.SUCCESS -> {
                    Log.d(TAG, "OpenCV loaded successfully")
                    javaCamera2View.enableView()
                }
                else -> super.onManagerConnected(status)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        if(OpenCVLoader.initDebug()) {
            Log.d(TAG, "OpenCV library found inside package. using it!")
            loaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
        }else{
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization.")
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, loaderCallback)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        javaCamera2View.disableView()
    }

    override fun onCameraViewStarted(width: Int, height: Int) {
        Log.d(TAG, "camera view size: ($width, $height)")
    }

    override fun onCameraViewStopped() {

    }

    override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame?): Mat {
        // convey grayscale image data to view
        return inputFrame!!.gray()
    }



}
