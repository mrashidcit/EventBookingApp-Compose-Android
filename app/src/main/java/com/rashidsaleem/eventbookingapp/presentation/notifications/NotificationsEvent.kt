package com.rashidsaleem.eventbookingapp.presentation.notifications

import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel

sealed class NotificationsEvent {
    data class AcceptInvitation(val data: NotificationModel): NotificationsEvent()
    data class RejectInvitation(val data: NotificationModel): NotificationsEvent()

    data object NavigateBack: NotificationsEvent()
}