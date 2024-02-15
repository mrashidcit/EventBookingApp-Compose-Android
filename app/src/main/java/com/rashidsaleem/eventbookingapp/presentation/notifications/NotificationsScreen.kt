package com.rashidsaleem.eventbookingapp.presentation.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel
import com.rashidsaleem.eventbookingapp.presentation.notifications.components.NotificationsContent

@Composable
fun NotificationsScreen() {

    val uiState = remember {
        NotificationsUiState(
            notifications = NotificationModel.dummyNotifications()
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        NotificationsContent(
            uiState = uiState,
        )
    }
}

