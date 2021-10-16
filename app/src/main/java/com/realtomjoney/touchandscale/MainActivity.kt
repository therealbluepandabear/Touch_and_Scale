package com.realtomjoney.touchandscale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import android.view.View
import java.lang.Float.max
import java.lang.Float.min

class MainActivity : AppCompatActivity() {
    lateinit var scaleGestureDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

private class ScaleListener(val myView: View) :
    ScaleGestureDetector.SimpleOnScaleGestureListener() {
    var scaleFactor = 1.0f

    override fun onScale(detector: ScaleGestureDetector?): Boolean {
        scaleFactor *= detector!!.scaleFactor

        myView.scaleX = scaleFactor
        myView.scaleY = scaleFactor

        return true
    }
}

