package com.rashidsaleem.eventbookingapp.presentation.common.routes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rashidsaleem.eventbookingapp.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int,
    ) {
    object Home: Screen(Routes.home, R.string.explore, R.drawable.ic_explore)
    object Events: Screen(Routes.events, R.string.events, R.drawable.ic_calendar)
    object Map: Screen(Routes.map, R.string.map, R.drawable.ic_location_on)
    object Profile: Screen(Routes.profile, R.string.profile, R.drawable.ic_person)
}

val listOfBottomNavItems = listOf<Screen>(
    Screen.Home,
    Screen.Events,
    Screen.Map,
    Screen.Profile
)