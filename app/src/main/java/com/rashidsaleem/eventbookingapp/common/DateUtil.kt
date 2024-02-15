package com.rashidsaleem.eventbookingapp.common

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import kotlin.math.abs

object DateUtil {

    private const val TAG = "DateUtil"

    const val ddMMMCommayyyy = "dd MMMM, yyyy" // e.g 14 December, 2024
    const val ddMMM = "dd MMM" // e.g 14 Dec
    const val EEEECommaHHmma = "EEEE, hh:mma" // Tuesday, 4:00PM - 9:00PM
    const val MMMDashyyyy = "MMM-yyyy" // e.g 14 December, 2024
    const val HHmma = "hh:mma" // 9:00PM
    const val ECommahhmma = "E,hh:mm a" //Fri 9:00 PM

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

    fun toStringForNotification(dateInMilliseconds: Long): String? {
        val date = try {
            Date(dateInMilliseconds)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        val calendar = Calendar.getInstance()
        val diff = dateInMilliseconds - calendar.time.time
        val seconds = diff / 1000
        if (seconds < 60) return "Just now"
        val minutes = seconds / 60
        if (minutes < 60) return "$minutes min ago"
        val hours = minutes / 60
        if (hours < 24) return "$hours hr ago"

        return toString(date, ECommahhmma)
    }

    fun toString(dateInMillieseconds: Long, format: String = ddMMMCommayyyy): String? {
        val date = try {
            Date(dateInMillieseconds)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        return toString(date, format)
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

    /**
     * Provide the date of Week 1st Day and Last Day ( for a given date in @param )
     * @param date - provide any date
     *
     * @return A [List<Date>] in which
     *      index 0 contains Week 1st Day Date
     *      index 1 contain Week last Day Date
     *      or Empty list in case of @param date is null or not valid
     */
    fun getWeek1stDayAndLastDayDate(date: Date?): List<Date> {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return try {
            val firstDayOfWeek = calendar.firstDayOfWeek
            val todayDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val dateOfFirstDayOfWeek = calendar.let {
                val daysDifference = abs(todayDayOfWeek - firstDayOfWeek)
                it.add(Calendar.DATE, - daysDifference)
                val date = it.time
                it.add(Calendar.DATE, daysDifference) // Resetting back to Today
                date
            }
            val dateOfLastDayOfWeek = calendar.let {
                val daysDifference = abs(Calendar.SATURDAY - todayDayOfWeek)
                it.add(Calendar.DATE, daysDifference)
                val date = it.time
                it.add(Calendar.DATE, - daysDifference)
                date
            }
            listOf(
                dateOfFirstDayOfWeek,
                dateOfLastDayOfWeek
            )
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }

}