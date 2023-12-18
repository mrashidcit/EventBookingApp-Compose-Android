package com.rashidsaleem.eventbookingapp.presentation.signUp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashidsaleem.eventbookingapp.presentation.signUp.components.SignUpContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel(),
    navigateNext: (String) -> Unit,
    navigateBack: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is SignUpViewModel.UiEvent.NavigateNext -> navigateNext(event.route)
                is SignUpViewModel.UiEvent.NavigateBack -> navigateBack(event.route)
            }
        }
    }

    SignUpContent(uiState = uiState, onEvent = { viewModel.onEvent(it) })
}