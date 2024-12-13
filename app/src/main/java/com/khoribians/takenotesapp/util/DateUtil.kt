package com.khoribians.takenotesapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



object DateUtil {

    const val TIME_DATE_FORMAT = "MMM dd, hh:mm aa"

    fun getTimeDate(format: String): String{
        val sdf: SimpleDateFormat = SimpleDateFormat(format, Locale("en"))
        val currentDateandTime: String = sdf.format(Date())
        return currentDateandTime
    }
}