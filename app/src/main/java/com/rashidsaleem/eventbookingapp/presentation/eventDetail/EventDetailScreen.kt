package com.rashidsaleem.eventbookingapp.presentation.eventDetail

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.presentation.common.components.BaseScreen
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.components.EventDetailContent

@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    bundle: Bundle,
    navigateBack: () -> Unit,
    navigateNext: (String) -> Unit,
) {

    val baseUiState by viewModel.baseUiState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.updateData(bundle)
    }

    BaseScreen(baseUiState = baseUiState) {

    }
    EventDetailContent(
        event = uiState.event,
        onEvent = { viewModel.onEvent(it) })
}

