package com.rashidsaleem.eventbookingapp.presentation.resetPassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rashidsaleem.eventbookingapp.presentation.resetPassword.components.ResetPasswordContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ResetPasswordScreen(
    viewModel: ResetPasswordViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String) -> Unit,
    navigateBack: () -> Unit,
) {
    val baseUiState by viewModel.baseUiState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is ResetPasswordViewModel.UiEvent.NavigateNext -> navigateNext(event.route)
                ResetPasswordViewModel.UiEvent.NavigateBack -> navigateBack()
            }
        }
    }

    ResetPasswordContent(
        baseUiState = baseUiState,
        uiState = uiState,
        onEvent = { viewModel.onEvent(it) },
    )

}