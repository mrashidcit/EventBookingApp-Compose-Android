package com.rashidsaleem.eventbookingapp

import android.app.Application
import com.rashidsaleem.eventbookingapp.common.AppUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EventApp: Application() {

    override fun onCreate() {
        super.onCreate()

        AppUtil.init(this@EventApp)
    }
}