package com.example.customcalendar.Adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import com.example.customcalendar.DataClasss.Day_Calendar
import com.example.customcalendar.R

class CalendarAdapter (val DateList : ArrayList<Day_Calendar>) : RecyclerView.Adapter<DateViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DateViewHolder {
        val View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_calendar_date,viewGroup,false)
        return DateViewHolder(View)
    }

    override fun getItemCount(): Int {
        return DateList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val SpecificDate = DateList.get(position)
        if(SpecificDate.Date==0){
            holder.Date.visibility = INVISIBLE
        }
        else{
            holder.Date.text = SpecificDate.Date.toString()
            if(SpecificDate.IsHoliday==true) {
                holder.Date.setTextColor(R.color.SaturdayBlue)
                Log.d("zz",holder.Date.text.toString())
                Log.d("zz",holder.Date.visibility.toString())
                Log.d("zz",holder.Date.textColors.toString())
            }
            holder.Date.visibility = VISIBLE
        }
        holder.Date.text =  SpecificDate.Date.toString()
        if(SpecificDate.IsHoliday == true)
            holder.Holiday.text = SpecificDate.Holiday
        else
            holder.Holiday.text = null
        if(SpecificDate.Events == null){
            holder.Events.text = null
        }
    }

}

class DateViewHolder(DateItemView : View) : RecyclerView.ViewHolder(DateItemView){
    val Date = DateItemView.findViewById<TextView>(R.id.date)
    val Holiday = DateItemView.findViewById<TextView>(R.id.holiday)
    var Events = DateItemView.findViewById<TextView>(R.id.events)
}