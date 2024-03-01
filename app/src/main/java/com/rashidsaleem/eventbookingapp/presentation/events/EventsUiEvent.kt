package com.rashidsaleem.eventbookingapp.presentation.events

import android.os.Bundle
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel

sealed class EventsUiEvent {
    data object NavigateBack: EventsUiEvent()
//    data class NavigateNext(val route: String, val params: Bundle): EventsUiEvent()
    data class TopAppBarBackArrowIconOnClick(val route: String): EventsUiEvent()
    data object TopAppBarSearchIconOnClick: EventsUiEvent()
    data object TopAppBarMoreIconOnClick: EventsUiEvent()
    data class SearchQueryValueChange(val value: String): EventsUiEvent()
    data object SearchIconOnClick: EventsUiEvent()
    data object FilterIconOnClick: EventsUiEvent()
    data class UpdateUiComponent(val value: EventsUiComponent): EventsUiEvent()
    data class BookmarkOnClick(val value: EventModel): EventsUiEvent()
    data class EventItemOnClick(val value: EventModel): EventsUiEvent()


}