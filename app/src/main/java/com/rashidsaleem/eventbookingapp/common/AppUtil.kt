package com.rashidsaleem.eventbookingapp.common

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
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

    fun followersForDisplay(followers: Int): String {
        return when {
            (followers < 1000) -> "$followers"
            else -> "${followers/1000}K"
        }
    }

    fun shareMessage(title: String, description: String, activity: ComponentActivity) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
//            putExtra(Intent.EXTRA_TITLE, title)
            putExtra(Intent.EXTRA_TEXT, "$title \n\n $description")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
         activity.startActivity(shareIntent)
    }


}