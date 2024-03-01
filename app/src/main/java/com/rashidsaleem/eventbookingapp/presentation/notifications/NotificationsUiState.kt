package com.rashidsaleem.eventbookingapp.presentation.notifications

import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel

data class NotificationsUiState(
    val notifications: ArrayList<NotificationModel> = arrayListOf(),
)
