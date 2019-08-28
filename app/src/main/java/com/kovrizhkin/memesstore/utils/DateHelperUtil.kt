package com.kovrizhkin.memesstore.utils

object DateHelperUtil {

    fun getDaysAgo(milliSeconds: Long): Int {
        // Create a calendar object that will convert the date and time value in milliseconds to date.


        return ((System.currentTimeMillis() - milliSeconds*1000) / 1000 / 60 / 60 / 24).toInt()
    }

}