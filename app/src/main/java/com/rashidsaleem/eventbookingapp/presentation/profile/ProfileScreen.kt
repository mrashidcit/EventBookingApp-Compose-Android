package com.rashidsaleem.eventbookingapp.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rashidsaleem.eventbookingapp.common.enums.DataState
import com.rashidsaleem.eventbookingapp.presentation.profile.components.ProfileContent

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.userDataState == DataState.Completed) {
        ProfileContent(uiState = uiState)
    }
}