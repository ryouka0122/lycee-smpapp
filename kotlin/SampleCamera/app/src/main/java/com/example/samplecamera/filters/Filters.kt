package com.example.samplecamera.filters

import org.opencv.core.*
import org.opencv.imgproc.Imgproc

fun makeFilterArray() : Array<ImageFilter> {
    return arrayOf(
        Filters.NoFilter(),
        Filters.BinaryFilter(),
        Filters.EdgeDetector()
    )
}


class Filters {

    class NoFilter : ImageFilter("NoFilter") {
        override fun process(src: Mat): Mat {
            return src
        }
    }

    class BinaryFilter : ImageFilter("BinaryFilter") {
        override fun process(src: Mat): Mat {
            Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY)
            Imgproc.adaptiveThreshold(src, src, 255.0, Imgproc.ADAPTIVE_THRESH_MEAN_C,
                Imgproc.THRESH_BINARY_INV, 7, 8.0)
            return src
        }
    }

    class EdgeDetector : ImageFilter("EdgeDetector") {
        private val base = BinaryFilter()

        override fun process(src: Mat): Mat {
            val res = base.process(src)

            val contours = mutableListOf<MatOfPoint>()
            val hierarchy = Mat()
            Imgproc.findContours(res, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE)

            val areas = mutableListOf<MatOfPoint>()
            for (cnt in contours) {
                val contour = MatOfPoint2f()
                cnt.convertTo(contour, CvType.CV_32FC2)

                val area : Double = Imgproc.contourArea(contour)
                if (area > 1000.0) {
                    val epsilon = 0.1 * Imgproc.arcLength(contour, true)
                    val approx = MatOfPoint2f()
                    Imgproc.approxPolyDP(contour, approx, epsilon, true)

                    MatOfPoint().let {
                        approx.convertTo(it, CvType.CV_32S)
                        areas.add(it)
                    }
                }
            }
            Imgproc.cvtColor(src, src, Imgproc.COLOR_GRAY2RGBA)
            Imgproc.drawContours(src, areas,  -1, Scalar(255.0, 0.0, 0.0), 3)
            return res
        }
    }


}