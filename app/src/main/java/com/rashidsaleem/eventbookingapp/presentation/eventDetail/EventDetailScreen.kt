package com.rashidsaleem.eventbookingapp.presentation.eventDetail

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.presentation.common.components.BaseScreen
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.FilterDialogView
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.InviteFriendDialogView
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.components.EventDetailContent
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeTopContainerEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    bundle: Bundle,
    navigateBack: () -> Unit,
    navigateNext: (String, Bundle?) -> Unit,
) {

    val baseUiState by viewModel.baseUiState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val sheetState = androidx.compose.material3.rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val _scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.updateData(bundle)

        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                EventDetailViewModel.UiEvent.NavigateBack -> navigateBack()
                is EventDetailViewModel.UiEvent.NavigateNext ->
                    navigateNext(event.route, event.params)
            }
        }
    }

    BaseScreen(baseUiState = baseUiState) {

    }
    EventDetailContent(
        event = uiState.event,
        onEvent = { viewModel.onEvent(it) })

    // InviteFriendDialog
    if (uiState.showInviteDialog) {
        ModalBottomSheet(
            onDismissRequest = {

            },
            sheetState = sheetState
        ) {
            // Sheet content
            InviteFriendDialogView() {
                _scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        viewModel.onEvent(
                            EventDetailEvent.ShowInviteDialog(false)
                        )
                    }
                }
            }
        }
    }


}

