package com.example.customcalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.customcalendar.Adapter.CalendarViewPagerAdapter
import kotlinx.android.synthetic.main.activity_calendar_view.*

class CalendarView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_view)

        CalendarViewPager.adapter = CalendarViewPagerAdapter(supportFragmentManager)
        CalendarViewPager.currentItem = 1
    }
}
