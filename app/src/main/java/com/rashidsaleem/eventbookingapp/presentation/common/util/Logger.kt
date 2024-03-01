package com.rashidsaleem.eventbookingapp.presentation.common.util

import android.os.Build
import android.util.Log
import com.rashidsaleem.eventbookingapp.BuildConfig

object Logger {
    fun d(tag: String, msg: String, thr: Throwable? = null) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg, thr)
        }
    }

    fun e(tag: String, msg: String, thr: Throwable? = null) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg, thr)
        }
    }


}