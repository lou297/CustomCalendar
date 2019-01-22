package com.example.customcalendar.CalendarFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customcalendar.Adapter.CalendarAdapter
import com.example.customcalendar.DataClasss.Day_Calendar
import com.example.customcalendar.R
import kotlinx.android.synthetic.main.fragment_previous_month.*
import java.util.*

class PreviousMonthFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_previous_month,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        SetCalendar(SetDate())
        super.onActivityCreated(savedInstanceState)
    }

    private fun SetDate() : Int{
        val PreviousCalendar = Calendar.getInstance()
        var PrevYear = PreviousCalendar.get(Calendar.YEAR)
        var PrevMonth = PreviousCalendar.get(Calendar.MONTH)-1

        if(PrevMonth==-1){
            PrevYear--
            PrevMonth=11
        }

        PreviousYear.text = "${PrevYear}년"
        PreviousMonth.text = "${PrevMonth+1}월"

        val FirstDay = Calendar.getInstance()
        FirstDay.set(PrevYear, PrevMonth,1)

        return FirstDay.get(Calendar.DAY_OF_WEEK)
    }

    private fun SetCalendar(FirstDay : Int){
        val DateList = ArrayList<Day_Calendar>()

        for(i in 1..FirstDay-1){
            DateList.add(Day_Calendar(Date=0))
        }

        val Calendar = Calendar.getInstance()
        var YEAR = Calendar.get(java.util.Calendar.YEAR)
        var MONTH = Calendar.get(java.util.Calendar.MONTH)-1

        if(MONTH==-1){
            YEAR--
            MONTH=11
        }
        Calendar.set(YEAR,MONTH,1)

        for(i in 1..Calendar.getActualMaximum(java.util.Calendar.DATE)){
            Calendar.set(YEAR,MONTH,i)
            if(Calendar.get(java.util.Calendar.DAY_OF_WEEK)==1)
                DateList.add(Day_Calendar(Date=i,IsHoliday = true))
            else
                DateList.add(Day_Calendar(Date=i))
        }

        PreviousMonthRecyclerView.layoutManager = GridLayoutManager(context,7)
        PreviousMonthRecyclerView.adapter = CalendarAdapter(DateList)
    }
}