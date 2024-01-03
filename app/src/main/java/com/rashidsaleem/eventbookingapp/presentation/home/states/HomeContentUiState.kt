package com.rashidsaleem.eventbookingapp.presentation.home.states

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel

data class HomeContentUiState(
    val upcomingEvents: List<EventModel> = listOf()
)
