package com.rashidsaleem.eventbookingapp.presentation.home.events

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel

sealed class HomeContentEvent {
    data object UpcomingEventSeeAll: HomeContentEvent()
    data class EventBookmarkOnClick(val value: EventModel): HomeContentEvent()
    data class EventCardOnClick(val value: EventModel): HomeContentEvent()
    data object InviteYourFriend: HomeContentEvent()
    data object NearbyYouSeeAll: HomeContentEvent()
}
