package com.example.customcalendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import com.example.customcalendar.Adapter.CalendarAdapter
import com.example.customcalendar.DataClasss.Day_Calendar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CalendarInstance = Calendar.getInstance()
        val PresentYear = CalendarInstance.get(Calendar.YEAR)
        val PresentMonth = CalendarInstance.get(Calendar.MONTH)+1
        val PresentDate = CalendarInstance.get(Calendar.DATE)

        TitleYear.text = "${PresentYear}년"
        TitleDate.text = "${PresentMonth} 월 ${PresentDate} 일"
        var DateList = arrayListOf<Day_Calendar>(
            Day_Calendar(Date = 1),
            Day_Calendar(Date = 2),
            Day_Calendar(Date = 3),
            Day_Calendar(Date = 4),
            Day_Calendar(Date = 5),
            Day_Calendar(Date = 6),
            Day_Calendar(Date = 7),
            Day_Calendar(Date = 8),
            Day_Calendar(Date = 9),
            Day_Calendar(Date = 10),
            Day_Calendar(Date = 11),
            Day_Calendar(Date = 12),
            Day_Calendar(Date = 13),
            Day_Calendar(Date = 14),
            Day_Calendar(Date = 15),
            Day_Calendar(Date = 16),
            Day_Calendar(Date = 17),
            Day_Calendar(Date = 18),
            Day_Calendar(Date = 19),
            Day_Calendar(Date = 20),
            Day_Calendar(Date = 21),
            Day_Calendar(Date = 22),
            Day_Calendar(Date = 23),
            Day_Calendar(Date = 24),
            Day_Calendar(Date = 25),
            Day_Calendar(Date = 26),
            Day_Calendar(Date = 27),
            Day_Calendar(Date = 28),
            Day_Calendar(Date = 29),
            Day_Calendar(Date = 30),
            Day_Calendar(Date = 31),
            Day_Calendar(Date = 32),
            Day_Calendar(Date = 33),
            Day_Calendar(Date = 34),
            Day_Calendar(Date = 35)


        )


        CalendarRecyclerView.layoutManager = GridLayoutManager(this,7)
        CalendarRecyclerView.adapter = CalendarAdapter(DateList)
    }

}
