package com.rashidsaleem.eventbookingapp.presentation.profile

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rashidsaleem.eventbookingapp.common.enums.DataStateEnum
import com.rashidsaleem.eventbookingapp.presentation.profile.components.ProfileContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProfileScreen(
    params: Bundle? = null,
    viewModel: ProfileViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String, Bundle?) -> Unit,
    navigateBack: () -> Unit,

) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = params) {
        params?.let { viewModel.updateParams(it) }
        viewModel.initData()

        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is ProfileViewModel.UiEvent.NavigateNext -> navigateNext(event.route, event.params)
                ProfileViewModel.UiEvent.NavigateBack -> navigateBack()
            }
        }

    }

    if (uiState.userDataState == DataStateEnum.Completed) {
        ProfileContent(
            uiState = uiState,
            onEvent = { event ->
                viewModel.onEvent(event)
            }
        )
    }
}