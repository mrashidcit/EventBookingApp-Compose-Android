package com.rashidsaleem.eventbookingapp.presentation.common

sealed class BaseEvent() {
    data class ShowLoader(val value: Boolean): BaseEvent()
}
