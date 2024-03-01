package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.components.InviteFriendContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun InviteFriendDialogView(
    viewModel: InviteFriendViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    closeDialog: () -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()
    val items by viewModel.items.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                InviteFriendViewModel.UiEvent.CloseDialog -> closeDialog()
            }
        }
    }

    InviteFriendContent(
        uiState = uiState,
        items = items,
        onEvent = viewModel::onEvent
    )

}