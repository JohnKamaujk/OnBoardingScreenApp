package com.example.onboardscreenapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(val context:Context):PagerAdapter(){

    var layoutInflater:LayoutInflater?=null
//    array of image,heading,description
    val imgArray= arrayOf(
    R.drawable.merc,
    R.drawable.audi,
    R.drawable.bmw,
    R.drawable.range
    )
    val headArray= arrayOf(
        "Mercedes Benz",
        "Audi Q7",
        "BMW 18",
        "Range Rover Sports"
    )
    val arrayDescription= arrayOf(
        "Mercedes-Benz pullman is a german luxury car that is one of the best models in the world.It retails for about $450000",
        "Audi Q8 is a motor sport car manufactured in Germany.It is one of the best motors in Europe.It retails for $400000",
        "BMW i8 is a super luxurious car made in Germany.It is a symbol of status luxury car.It retails for about $420000",
        "Range Rover sports is a land rover sports car that is made in the UK.It retails for $550000"
    )


    override fun getCount(): Int {
        return headArray.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider,container,false)

        val img=view.findViewById<ImageView>(R.id.image)
        val txt_head=view.findViewById<TextView>(R.id.txt_head)
        val txt_description=view.findViewById<TextView>(R.id.txt_description)

        img.setImageResource(imgArray[position])
        txt_head.text=headArray[position]
        txt_description.text=arrayDescription[position]

        container.addView(view)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}