package com.example.onboardscreenapp

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager:ViewPager
    private lateinit var viewPagerAdapter:ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val relativeLayout=findViewById<RelativeLayout>(R.id.layout1)

        val btn=findViewById<Button>(R.id.btn)
        val dotsIndicator=findViewById<DotsIndicator>(R.id.dots_indicator)
        val animationDrawable=relativeLayout.background as AnimationDrawable
        addAnimation(animationDrawable)

        viewPager=findViewById(R.id.viewpager)
        viewPagerAdapter= ViewPagerAdapter(this)
        viewPager.adapter=viewPagerAdapter

        dotsIndicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position==0){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation123)
                    val animationDrawable=relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btn.visibility=View.INVISIBLE
                }
                if (position==1){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation456)
                    val animationDrawable=relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btn.visibility=View.INVISIBLE
                }
                if (position==2){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation789)
                    val animationDrawable=relativeLayout.background as AnimationDrawable
                   addAnimation(animationDrawable)
                    btn.visibility=View.INVISIBLE
                }
                if (position==3){
                    relativeLayout.setBackgroundResource(R.drawable.garadient_animation101112)
                    val animationDrawable=relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btn.visibility=View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })


    }
    fun addAnimation(animationDrawable:AnimationDrawable){
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()

    }
}