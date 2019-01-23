package com.example.customcalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.customcalendar.Adapter.CalendarViewPagerAdapter
import kotlinx.android.synthetic.main.activity_calendar_view.*
import java.util.*

class CalendarView : AppCompatActivity() {
    companion object {
        internal var ShowYear = 0
        internal var ShowMonth = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_view)

        GetDate()

        CalendarViewPager.adapter = CalendarViewPagerAdapter(supportFragmentManager)
        CalendarViewPager.currentItem = 1

        CalendarViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> if(ShowMonth==0){
                        ShowYear--
                        ShowMonth=12
                        }
                        else
                            ShowMonth--

                    2 -> if(ShowMonth==11){
                        ShowYear++
                        ShowMonth=1
                        }
                        else
                            ShowMonth++
                }

            }

        })


    }

    fun GetDate(){
        val calendar = Calendar.getInstance()
        ShowYear = calendar.get(Calendar.YEAR)
        ShowMonth = calendar.get(Calendar.MONTH)
        Log.d("test",ShowYear.toString())
        Log.d("test",ShowMonth.toString())
    }


}




