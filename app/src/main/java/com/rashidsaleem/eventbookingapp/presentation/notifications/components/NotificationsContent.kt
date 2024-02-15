package com.rashidsaleem.eventbookingapp.presentation.notifications.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.notifications.NotificationsUiState

@Composable
fun NotificationsContent(
    uiState: NotificationsUiState
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

        NotificationList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            notifications = uiState.notifications)
    }
}