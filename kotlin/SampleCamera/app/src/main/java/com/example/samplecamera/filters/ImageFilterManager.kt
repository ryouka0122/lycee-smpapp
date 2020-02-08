package com.example.samplecamera.filters

import org.opencv.core.Mat

class ImageFilterManager {
    private val filters = makeFilterArray()

    private var currentFilter = filters[0]
    private var currentIndex = 0

    private val syncObj = Object()

    fun next() {
        synchronized(syncObj) {
            currentIndex = (currentIndex + 1) % filters.size
            currentFilter = filters[currentIndex]
        }

    }

    fun currentName() : String {
        synchronized(syncObj) {
            return currentFilter.getName()
        }
    }


    fun process(src : Mat) : Mat {
        synchronized(syncObj) {
            return currentFilter.process(src)
        }
    }

}