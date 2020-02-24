package com.example.imageswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val flowers = intArrayOf(R.drawable.flower1,
        R.drawable.flower2, R.drawable.flower4)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access the ImageSwitcher
        val imgSwitcher = findViewById<ImageSwitcher>(R.id.imgSw)

        imgSwitcher?.setFactory({
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        })

        // set the method and pass array as a parameter
        imgSwitcher?.setImageResource(flowers[index])

        val imgIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left)
        imgSwitcher?.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right)
        imgSwitcher?.outAnimation = imgOut

        // previous button functionality
        val prev = findViewById<Button>(R.id.prev)
        prev.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else 2
            imgSwitcher?.setImageResource(flowers[index])
        }
        // next button functionality
        val next = findViewById<Button>(R.id.next)
        next.setOnClickListener {
            index = if (index + 1 < flowers.size) index +1 else 0
            imgSwitcher?.setImageResource(flowers[index])
        }
    }
}
