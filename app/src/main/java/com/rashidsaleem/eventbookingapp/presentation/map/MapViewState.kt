package com.rashidsaleem.eventbookingapp.presentation.map

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel

data class MapViewState(
    val searchQuery: String = "",
    val events: ArrayList<EventModel> = arrayListOf()
)
