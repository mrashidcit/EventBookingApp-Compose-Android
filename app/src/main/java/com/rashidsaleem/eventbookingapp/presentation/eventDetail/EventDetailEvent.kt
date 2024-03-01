package com.rashidsaleem.eventbookingapp.presentation.eventDetail

import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel

sealed class EventDetailEvent {
    data object NavigateBack: EventDetailEvent()
    data class  Bookmark(val event: EventModel): EventDetailEvent()
    data class  ShowInviteDialog(val value: Boolean): EventDetailEvent()
    data class  PlusGoingPersons(val event: EventModel): EventDetailEvent()
    data object  Follow: EventDetailEvent()
    data object  OrganizerProfileDetail: EventDetailEvent()
    data class BuyTicket(val event: EventModel): EventDetailEvent()

}