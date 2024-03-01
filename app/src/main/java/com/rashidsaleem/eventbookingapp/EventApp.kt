package com.rashidsaleem.eventbookingapp

import android.app.Application
import android.util.Log
import com.rashidsaleem.eventbookingapp.common.AppUtil
import com.rashidsaleem.eventbookingapp.common.DateUtil
import dagger.hilt.android.HiltAndroidApp
import java.util.Calendar
import java.util.Locale
import java.util.logging.Logger
import kotlin.math.abs

@HiltAndroidApp
class EventApp: Application() {

    private val TAG = "EventApp"
    override fun onCreate() {
        super.onCreate()

        AppUtil.init(this@EventApp)

        // Test Code
//        val calendar = Calendar.getInstance(
//            Locale.getDefault()
//        )
//        Log.d(TAG, "onCreate: date = ${DateUtil.toString(calendar.time)}")
//        val firstDayOfWeek = calendar.firstDayOfWeek
//        val todayDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
//        val dateOfFirstDayOfWeek = calendar.let {
//            val daysDifference = abs(todayDayOfWeek - firstDayOfWeek)
//            it.add(Calendar.DATE, - daysDifference)
//            val date = it.time
//            it.add(Calendar.DATE, daysDifference) // Resetting back to Today
//            date
//        }
//        val dateOfLastDayOfWeek = calendar.let {
//            val daysDifference = abs(Calendar.SATURDAY - todayDayOfWeek)
//            it.add(Calendar.DATE, daysDifference)
//            val date = it.time
//            it.add(Calendar.DATE, - daysDifference)
//            date
//        }
//        Log.d(TAG, "onCreate: dateOfFirstDayOfWeek = ${DateUtil.toString(dateOfFirstDayOfWeek)}")
//        Log.d(TAG, "onCreate: dateOfLastDayOfWeek = ${DateUtil.toString(dateOfLastDayOfWeek)}")


    }
}