package com.example.samplecamera.filters

import org.opencv.core.Mat

abstract class ImageFilter(
    private val name: String
) {

    fun getName() : String {
        return name
    }

    abstract fun process(src : Mat) : Mat

}
