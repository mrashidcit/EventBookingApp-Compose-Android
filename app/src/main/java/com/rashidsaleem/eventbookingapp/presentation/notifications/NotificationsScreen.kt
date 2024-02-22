package com.rashidsaleem.eventbookingapp.presentation.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashidsaleem.eventbookingapp.common.AppUtil
import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel
import com.rashidsaleem.eventbookingapp.presentation.notifications.components.NotificationsContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NotificationsScreen(
    viewModel: NotificationsViewModel = viewModel(),
    navigateBack: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    val notifications by viewModel.notifications.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {

        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                NotificationsViewModel.UiEvent.NavigateBack -> navigateBack()
                is NotificationsViewModel.UiEvent.ShowToast -> AppUtil.showToast(
                    message = event.value.asString(context)
                )

            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        NotificationsContent(
            uiState = uiState,
            notifications = notifications,
            onEvent = viewModel::onEvent
        )
    }
}

