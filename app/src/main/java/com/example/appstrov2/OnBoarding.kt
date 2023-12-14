package com.example.appstrov2

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.appstrov2.ui.HomeActivity
import com.example.appstrov2.ui.login.LoginActivity


class OnBoarding : AppCompatActivity() {
    var mSLideViewPager: ViewPager? = null
    var mDotLayout: LinearLayout? = null
    var nextbtn: Button? = null
    var skipbtn: Button? = null
    var dots: Array<TextView?> = arrayOfNulls(5)
    var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        nextbtn = findViewById<Button>(R.id.nextbtn)
        skipbtn = findViewById<Button>(R.id.skipButton)

        nextbtn?.setOnClickListener(View.OnClickListener {
            if (getitem(0) < 5) {  // Menjaga agar tidak mencoba mengakses slide ke-5 (indeks 4)
                mSLideViewPager?.setCurrentItem(getitem(1), true)
            } else {
                val i = Intent(this@OnBoarding, LoginActivity::class.java)
                startActivity(i)
                finish()
            }
        })


        skipbtn?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@OnBoarding, LoginActivity::class.java)
            startActivity(i)
            finish()
        })

        mSLideViewPager = findViewById<View>(R.id.slideViewPager) as ViewPager
        mDotLayout = findViewById<View>(R.id.indicator_layout) as LinearLayout
        viewPagerAdapter = ViewPagerAdapter(this)
        mSLideViewPager!!.adapter = viewPagerAdapter
        setUpindicator(0)
        mSLideViewPager!!.addOnPageChangeListener(viewListener)
    }

    fun setUpindicator(position: Int) {
        dots = arrayOfNulls(5)
        mDotLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226")
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(resources.getColor(R.color.inactive, applicationContext.theme))
            mDotLayout!!.addView(dots[i])
        }
        dots[position]!!.setTextColor(resources.getColor(R.color.active, applicationContext.theme))
    }

    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            setUpindicator(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }

    private fun getitem(i: Int): Int {
        return mSLideViewPager!!.currentItem + i
    }
}