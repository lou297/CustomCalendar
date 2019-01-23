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
import kotlinx.android.synthetic.main.fragment_previous_month.*
import kotlinx.android.synthetic.main.fragment_this_month.*
import java.util.*

class ThisMonthFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        SetCalendar(SetDate())

        return inflater.inflate(R.layout.fragment_this_month, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("test2",CalendarView.ShowYear.toString())
        Log.d("test2",CalendarView.ShowMonth.toString())
        SetDate(CalendarView.ShowYear, CalendarView.ShowMonth)
        super.onActivityCreated(savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser&&ThisMonthFragment::getLifecycle==Lifecycle.Event.ON_CREATE) {
            Log.d("test444", "들어옴")
            SetDate(CalendarView.ShowYear, CalendarView.ShowMonth)
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

    private fun SetDate(ShowYear: Int, ShowMonth: Int) {
        ThisYear.text = "${ShowYear}년"
        ThisMonth.text = "${ShowMonth + 1}월"

        Log.d("test3",(ShowYear).toString())
        Log.d("test3",(ShowMonth+1).toString())
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

        ThisMonthRecyclerView.layoutManager = GridLayoutManager(context, 7)
        ThisMonthRecyclerView.adapter = CalendarAdapter(DateList)
    }
}

