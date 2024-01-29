package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.components.FilterContent

@Composable
fun FilterDialogView(
    viewModel: FilterViewModel = androidx.lifecycle.viewmodel.compose.viewModel(LocalContext.current as ComponentActivity),
    showDialog: (Boolean) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val horizontalItems = viewModel.horizontalItems


    FilterContent(
        uiState = uiState,
        horizontalItems = horizontalItems,
        onEvent = { event ->
            when (event) {
                FilterDialogEvent.Apply -> {
                    showDialog(false)
                }

                FilterDialogEvent.Reset -> {

                }
                else -> viewModel.onEvent(event)
            }
        }
    )
}