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
import kotlinx.android.synthetic.main.fragment_this_month.*
import java.util.*

class ThisMonthFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        SetCalendar(SetDate())

        return inflater.inflate(R.layout.fragment_this_month,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        SetCalendar(SetDate())
        super.onActivityCreated(savedInstanceState)
    }


    private fun SetDate() : Int{
        val ThisCalendar = Calendar.getInstance()
        val TSYear = ThisCalendar.get(Calendar.YEAR)
        val TSMonth = ThisCalendar.get(Calendar.MONTH)

        ThisYear.text = "${TSYear}년"
        ThisMonth.text = "${TSMonth+1}월"

        val FirstDay = Calendar.getInstance()
        FirstDay.set(TSYear, TSMonth,1)

        return FirstDay.get(Calendar.DAY_OF_WEEK)
    }

    private fun SetCalendar(FirstDay : Int){
        val DateList = ArrayList<Day_Calendar>()

        for(i in 1..FirstDay-1){
            DateList.add(Day_Calendar(Date=0))
        }

        val Calendar = Calendar.getInstance()
        val YEAR = Calendar.get(java.util.Calendar.YEAR)
        val MONTH = Calendar.get(java.util.Calendar.MONTH)

        for(i in 1..Calendar.getActualMaximum(java.util.Calendar.DATE)){
            Calendar.set(YEAR,MONTH,i)
            if(Calendar.get(java.util.Calendar.DAY_OF_WEEK)==1)
                DateList.add(Day_Calendar(Date=i,IsHoliday = true))
            else
                DateList.add(Day_Calendar(Date=i))
        }

        ThisMonthRecyclerView.layoutManager = GridLayoutManager(context,7)
        ThisMonthRecyclerView.adapter = CalendarAdapter(DateList)
    }
}