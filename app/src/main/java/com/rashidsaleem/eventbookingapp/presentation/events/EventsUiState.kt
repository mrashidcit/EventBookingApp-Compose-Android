package com.rashidsaleem.eventbookingapp.presentation.events

data class EventsUiState(
    val searchQuery: String = "",
    val showSearchBoxContainer: Boolean = false,
    val uiComponent: EventsUiComponent = EventsUiComponent.Upcoming
)

enum class EventsUiComponent {
    Upcoming, // Default
    PastEvents,
    AllEvents,
    Search
}
