package com.rashidsaleem.eventbookingapp.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object DateUtil {
    fun getDay(date: Date?): String? {
        if (date == null) return null
        val dateFormat: SimpleDateFormat  = SimpleDateFormat("dd")
        return dateFormat.format(date)
    }

    fun getMonth(date: Date?): String? {
        if (date == null) return null
        val dateFormat: SimpleDateFormat  = SimpleDateFormat("MMM")
        return dateFormat.format(date)
    }


}