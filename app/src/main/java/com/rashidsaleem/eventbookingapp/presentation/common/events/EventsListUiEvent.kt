package com.rashidsaleem.eventbookingapp.presentation.common.events

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.events.EventsUiEvent

sealed class EventsListUiEvent {
    data class BookmarkOnClick(val value: EventModel): EventsListUiEvent()
    data class EventItemOnClick(val value: EventModel): EventsListUiEvent()
}