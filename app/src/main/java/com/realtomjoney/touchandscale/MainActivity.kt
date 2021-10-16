package com.realtomjoney.touchandscale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import com.realtomjoney.touchandscale.databinding.ActivityMainBinding
import java.lang.Float.max
import java.lang.Float.min

class MainActivity : AppCompatActivity() {
    lateinit var scaleGestureDetector: ScaleGestureDetector

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()

        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener(binding.redView))
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return true
    }

    private fun setBindings() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

