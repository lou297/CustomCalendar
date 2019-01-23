package com.example.customcalendar.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.customcalendar.CalendarFragment.NextMonthFragment
import com.example.customcalendar.CalendarFragment.PreviousMonthFragment
import com.example.customcalendar.CalendarFragment.ThisMonthFragment

class CalendarViewPagerAdapter(FM : FragmentManager) : FragmentPagerAdapter(FM) {
    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> PreviousMonthFragment()

            1 -> ThisMonthFragment()

            2 -> NextMonthFragment()

            else -> null
        }
    }

    override fun getCount() = 3


}