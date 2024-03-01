package com.rashidsaleem.eventbookingapp.presentation.eventDetail

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel

data class EventDetailState(
    val event: EventModel = EventModel(
        id = 5
    ),
    val showInviteDialog: Boolean = false,
)
