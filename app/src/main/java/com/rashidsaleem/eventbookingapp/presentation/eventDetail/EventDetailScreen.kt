package com.rashidsaleem.eventbookingapp.presentation.eventDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rashidsaleem.eventbookingapp.presentation.common.components.BaseScreen
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.components.EventDetailContent

@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateBack: () -> Unit,
    navigateNext: (String) -> Unit,
) {

    val baseUiState by viewModel.baseUiState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    BaseScreen(baseUiState = baseUiState) {

    }
    EventDetailContent(
        event = uiState.event,
        onEvent = { viewModel.onEvent(it) })
}

