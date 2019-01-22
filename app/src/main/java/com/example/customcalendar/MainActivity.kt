package com.example.customcalendar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.widget.GridLayout
import com.example.customcalendar.Adapter.CalendarAdapter
import com.example.customcalendar.DataClasss.Day_Calendar
import kotlinx.android.synthetic.main.activity_main.*
import java.time.DayOfWeek
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var DateList = ArrayList<Day_Calendar>()

        val DayOfWeek = SetDate()

        for(i in 1..DayOfWeek-1){
            DateList.add(Day_Calendar(Date=0))
        }

        var GetDayOfWeek = Calendar.getInstance()
        val PresentYear = GetDayOfWeek.get(Calendar.YEAR)
        val PresentMonth = GetDayOfWeek.get(Calendar.MONTH)

        for(i in 1..Calendar.getInstance().getActualMaximum(Calendar.DATE)){
            GetDayOfWeek.set(PresentYear,PresentMonth,i)
            if(GetDayOfWeek.get(Calendar.DAY_OF_WEEK)==1)
                DateList.add(Day_Calendar(Date=i,IsHoliday = true))
            else
                DateList.add(Day_Calendar(Date=i))
        }
        NextBut.setOnClickListener{
            startActivity(Intent(this,CalendarView::class.java))
        }

        CalendarRecyclerView.layoutManager = GridLayoutManager(this,7)
        CalendarRecyclerView.adapter = CalendarAdapter(DateList)
    }

    private fun SetDate() : Int{
        val PresentCalendar = Calendar.getInstance()
        val PresentYear = PresentCalendar.get(Calendar.YEAR)
        val PresentMonth = PresentCalendar.get(Calendar.MONTH)+1
        val PresentDate = PresentCalendar.get(Calendar.DATE)

        TitleYear.text = "${PresentYear}년"
        TitleDate.text = "${PresentMonth} 월 ${PresentDate} 일"

        var FirstDay = Calendar.getInstance()
        FirstDay.set(PresentCalendar.get(Calendar.YEAR), PresentCalendar.get(Calendar.MONTH),1)

        return FirstDay.get(Calendar.DAY_OF_WEEK)
    }


}
