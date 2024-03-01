package com.rashidsaleem.eventbookingapp.presentation.notifications.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.notifications.NotificationsEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun NotificationList(
    modifier: Modifier = Modifier,
    notifications: List<NotificationModel>,
    onEvent: (NotificationsEvent) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(notifications) { notification ->
            NotificationItem(
                notification = notification,
                acceptOnClick = {
                    onEvent(NotificationsEvent.AcceptInvitation(notification))
                },
                rejectOnClick = {
                    onEvent(NotificationsEvent.RejectInvitation(notification))
                }
            )
        }
    }
}

@Preview
@Composable
fun NotificationListPreview() {
    EventBookingAppTheme {
        Surface {
            val items = remember {
                NotificationModel.dummyNotifications()
            }
            NotificationList(
                notifications = items,
                onEvent = {

                }
            )
        }
    }
}

