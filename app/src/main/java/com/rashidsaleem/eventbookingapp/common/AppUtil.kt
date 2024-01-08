package com.rashidsaleem.eventbookingapp.common

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rashidsaleem.eventbookingapp.EventApp

object AppUtil {

    private var _appContext: Context? = null

    fun init(app: EventApp) {
        _appContext = app.applicationContext
    }

    fun getStringResource(@StringRes id: Int): String = _appContext?.getString(id) ?: ""

    fun showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
        _appContext?.let { ctx ->
            Toast.makeText(
                ctx,
                message,
                length
            ).show()
        }
    }


}