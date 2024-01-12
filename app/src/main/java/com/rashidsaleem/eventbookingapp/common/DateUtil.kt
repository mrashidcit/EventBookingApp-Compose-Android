package com.rashidsaleem.eventbookingapp.common

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object DateUtil {

    private const val TAG = "DateUtil"

    const val ddMMMCommayyyy = "dd MMMM, yyyy" // e.g 14 December, 2024
    const val EEEECommaHHmma = "EEEE, hh:mma" // Tuesday, 4:00PM - 9:00PM
    const val HHmma = "hh:mma" // 9:00PM

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

    fun toString(date: Date?, format: String = ddMMMCommayyyy): String? {
        val dateFormat: SimpleDateFormat  = SimpleDateFormat(format)
        return try {
            dateFormat.format(date)
        } catch (ex: Exception) {
            Log.e(TAG, ex.message, ex)
            null
        }
    }


}