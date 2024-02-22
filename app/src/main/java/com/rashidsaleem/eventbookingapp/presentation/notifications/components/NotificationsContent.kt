package com.rashidsaleem.eventbookingapp.presentation.notifications.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.notifications.NotificationsEvent
import com.rashidsaleem.eventbookingapp.presentation.notifications.NotificationsUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray31

@Composable
fun NotificationsContent(
    uiState: NotificationsUiState,
    notifications: List<NotificationModel>,
    onEvent: (NotificationsEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            contentColor = Color.Black,
            text = stringResource(id = R.string.notification),
            trailingIcons = {
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.ic_more_vertical),
                    contentDescription = null,
                )
            },
            leadingIconOnClick = {

            },
        )
        Spacer(modifier = Modifier.height(35.dp))

        if (notifications.isNotEmpty()) {
            NotificationList(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
//                notifications = uiState.notifications,
                notifications = notifications,
                onEvent = onEvent
            )
        } else {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_empty_notifications),
                    contentDescription = null,
                    modifier = Modifier
                        .width(155.92.dp)
                        .height(169.21.dp)
                )
                Spacer(modifier = Modifier.height(40.5.dp))
                AppText(
                    text = stringResource(id = R.string.no_notifications),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 34.sp,
                    color = Gray31,
                )
                Spacer(modifier = Modifier.height(7.dp))
                AppText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 26.sp,
                    color = Gray31,
                    textAlign = TextAlign.Center,
                )

            }

        }

    }
}

@Preview
@Composable
fun NotificationsContentPreview() {
    val uiState = remember {
        NotificationsUiState(
            notifications = NotificationModel.dummyNotifications()
//            notifications = listOf()
        )
    }
    EventBookingAppTheme {
        Surface(
            color = Color.White,
        ) {
            NotificationsContent(
                uiState = uiState,
                notifications = NotificationModel.dummyNotifications(),
                onEvent = {

                }
                )
        }
    }
}