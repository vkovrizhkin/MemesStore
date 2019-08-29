package com.kovrizhkin.memesstore.utils

import com.kovrizhkin.memesstore.App
import com.kovrizhkin.memesstore.R

object DateHelperUtil {

    private fun getDaysAgo(milliSeconds: Long): Int {
        // Create a calendar object that will convert the date and time value in milliseconds to date.


        return ((System.currentTimeMillis() - milliSeconds * 1000) / 1000 / 60 / 60 / 24).toInt()
    }

    fun getFormattedDaysAgo(milliSeconds: Long): String {

        val days = getDaysAgo(milliSeconds)

        return when (days) {
            0 -> App.getContext()!!.getString(R.string.today)
            1 -> App.getContext()!!.getString(R.string.yesterday)
            else -> {
                when (days / 10) {
                    1 -> App.getContext()!!.getString(R.string.days_ago3, days)
                    else -> {
                        when (days % 10) {
                            1 -> App.getContext()!!.getString(R.string.days_ago1, days)
                            2, 3, 4 -> App.getContext()!!.getString(R.string.days_ago2, days)
                            0, 5, 6, 7, 8, 9 -> App.getContext()!!.getString(
                                R.string.days_ago3,
                                days
                            )
                            else -> App.getContext()!!.getString(R.string.days_ago3, days)
                        }
                    }
                }
            }
        }


    }

}