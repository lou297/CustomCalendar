package com.example.customcalendar.CalendarFragment

import android.arch.lifecycle.Lifecycle
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customcalendar.Adapter.CalendarAdapter
import com.example.customcalendar.CalendarView
import com.example.customcalendar.DataClasss.Day_Calendar
import com.example.customcalendar.R
import kotlinx.android.synthetic.main.fragment_next_month.*
import kotlinx.android.synthetic.main.fragment_previous_month.*
import kotlinx.android.synthetic.main.fragment_this_month.*
import java.util.*

class NextMonthFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        return inflater.inflate(R.layout.fragment_next_month,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        SetDate(CalendarView.ShowYear, CalendarView.ShowMonth)
        super.onActivityCreated(savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if(isVisibleToUser){
            Log.d("Test5","보인당")
            Log.d("testCalendar","Previous에서는 ${CalendarView.ShowYear}년 ${CalendarView.ShowMonth}월")
            SetDate(CalendarView.ShowYear, CalendarView.ShowMonth)
        }
        else if(isVisibleToUser==false&&this.lifecycle.currentState== Lifecycle.State.RESUMED){
            Log.d("Test5","안보인당")
            if(CalendarView.ShowMonth==11){
                SetDate(CalendarView.ShowYear+1,0)
            } else{
                SetDate(CalendarView.ShowYear, CalendarView.ShowMonth+1)
            }
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

    internal fun SetDate(ShowYear: Int, ShowMonth: Int) {
        NextYear.text = "${ShowYear}년"
        NextMonth.text = "${ShowMonth + 1}월"

        val calendar = Calendar.getInstance()
        calendar.set(ShowYear, ShowMonth, 1)

        val DateList = ArrayList<Day_Calendar>()

        for (i in 1..calendar.get(Calendar.DAY_OF_WEEK) - 1) {
            DateList.add(Day_Calendar(Date = 0))
        }

        for (i in 1..calendar.getActualMaximum(java.util.Calendar.DATE)) {
            calendar.set(ShowYear, ShowMonth, i)
            if (calendar.get(java.util.Calendar.DAY_OF_WEEK) == 1)
                DateList.add(Day_Calendar(Date = i, IsHoliday = true))
            else
                DateList.add(Day_Calendar(Date = i))
        }

        NextMonthRecyclerView.layoutManager = GridLayoutManager(context, 7)
        NextMonthRecyclerView.adapter = CalendarAdapter(DateList)
    }
}