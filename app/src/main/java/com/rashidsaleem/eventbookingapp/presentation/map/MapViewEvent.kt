package com.rashidsaleem.eventbookingapp.presentation.map

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.home.HorizontalItemEnum

sealed class MapViewEvent {
    data class PerformSearch(val value: String): MapViewEvent()
    data class TopListItemOnClick(val value: HorizontalItemEnum): MapViewEvent()
    data class EventListItemOnClick(val value: EventModel): MapViewEvent()
    data class EventBookMark(val value: EventModel): MapViewEvent()
    data object BackArrowIconOnClick: MapViewEvent()
    data object MyLocationIconOnClick: MapViewEvent()

}