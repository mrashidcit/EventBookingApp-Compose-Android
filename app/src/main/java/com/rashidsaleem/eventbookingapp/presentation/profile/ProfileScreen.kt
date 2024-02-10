package com.rashidsaleem.eventbookingapp.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rashidsaleem.eventbookingapp.common.enums.DataStateEnum
import com.rashidsaleem.eventbookingapp.presentation.profile.components.ProfileContent

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.userDataState == DataStateEnum.Completed) {
        ProfileContent(
            uiState = uiState,
            onEvent = { event ->
                viewModel.onEvent(event)
            }
            )
    }
}