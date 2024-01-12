package com.rashidsaleem.eventbookingapp.presentation.map

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rashidsaleem.eventbookingapp.presentation.common.components.BaseScreen
import com.rashidsaleem.eventbookingapp.presentation.map.components.MapViewContent

@Composable
fun MapScreen(
    viewModel: MapScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String, Bundle) -> Unit,
    navigateBack: () -> Unit,
) {

    val baseUiState by viewModel.baseUiState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collect{ event ->
            when(event) {
                MapScreenViewModel.UiEvent.NavigateBack -> navigateBack()
                is MapScreenViewModel.UiEvent.NavigateNext -> navigateNext(event.route, event.params)
            }
        }
    }

    BaseScreen(baseUiState = baseUiState) {
        MapViewContent(
            uiState = uiState,
            onEvent = { viewModel.onEvent(it) }
        )
    }
}