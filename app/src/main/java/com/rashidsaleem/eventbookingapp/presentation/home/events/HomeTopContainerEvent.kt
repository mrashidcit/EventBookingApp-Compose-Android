package com.rashidsaleem.eventbookingapp.presentation.home.events

import com.rashidsaleem.eventbookingapp.presentation.home.HorizontalItemEnum

sealed class HomeTopContainerEvent {
    object MenuIconClick: HomeTopContainerEvent()
    object NotificationIconClick: HomeTopContainerEvent()
    object CurrentLocationClick: HomeTopContainerEvent()
    object SearchIconClick: HomeTopContainerEvent()
    data class SearchFilterContainerClick(val value: Boolean): HomeTopContainerEvent()
    data class UpdateSearchFieldValue(val value: String): HomeTopContainerEvent()
    data class HorizontalListItemClick(val value: HorizontalItemEnum): HomeTopContainerEvent()


}