package com.rashidsaleem.eventbookingapp.presentation.events

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rashidsaleem.eventbookingapp.presentation.events.components.EventsContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String, Bundle) -> Unit,
    navigateBack: (String) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()
    val eventsList by viewModel.eventsListForDisplay.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                EventsViewModel.UiEvent.NavigateBack -> navigateBack("")
                is EventsViewModel.UiEvent.NavigateNext -> navigateNext(event.route, event.params)
            }

        }
    }

    EventsContent(
        uiState = uiState,
        eventsList = eventsList,
        onEvent = { event ->
            viewModel.onEvent(event)
        }
    )
}