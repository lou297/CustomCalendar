package com.example.customcalendar.DataClasss

class Day_Calendar (Date : Int, IsHoliday :Boolean = false, Holiday : String? = null, Events : ArrayList<String>? = null){
    val Date = Date
    val IsHoliday = IsHoliday
    val Holiday = Holiday
    var Events = Events
}