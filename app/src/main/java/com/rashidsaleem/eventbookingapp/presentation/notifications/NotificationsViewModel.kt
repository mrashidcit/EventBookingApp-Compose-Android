package com.rashidsaleem.eventbookingapp.presentation.notifications

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel
import com.rashidsaleem.eventbookingapp.presentation.common.util.UiText
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor() : BaseViewModel() {

    private val TAG = "NotificationsViewModel"
    private val _scope = viewModelScope
    private val _uiState: MutableStateFlow<NotificationsUiState> = MutableStateFlow(NotificationsUiState())
    val uiState: StateFlow<NotificationsUiState> = _uiState.asStateFlow()
    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()
    private val _notifications: MutableStateFlow<SnapshotStateList<NotificationModel>> = MutableStateFlow(mutableStateListOf<NotificationModel>())
    var notifications = _notifications.asStateFlow()

    init {
        _scope.launch {
            val items = NotificationModel.dummyNotifications() as ArrayList

            _notifications.value.addAll(items)
            _uiState.update {
                it.copy(
                    notifications = items
                )
            }
        }

    }

    fun onEvent(event: NotificationsEvent) {
        when (event) {
            is NotificationsEvent.AcceptInvitation -> acceptInvitation(event.data)
            is NotificationsEvent.RejectInvitation -> rejectInvitation(event.data)
            NotificationsEvent.NavigateBack -> navigateBack()
        }
    }

    private fun navigateBack() = _scope.launch(Dispatchers.Main) {

        _eventFlow.emit(UiEvent.NavigateBack)
    }

    private fun rejectInvitation(notification: NotificationModel) = _scope.launch {

        val itemIndex = _notifications
            .value
            .indexOfFirst { it.id == notification.id }

        Log.d(TAG, "rejectInvitation: before - itemIndex = $itemIndex ... size = ${_notifications.value.size}")
        if (itemIndex != -1) {
            _notifications.value.removeAt(itemIndex)
        }
        Log.d(TAG, "rejectInvitation: before - itemIndex = $itemIndex ... size = ${_notifications.value.size}")

        launch(Dispatchers.Main) {
            _eventFlow.emit(
                UiEvent.ShowToast(
                    UiText.StringResource(R.string.successfully_updated)
                )
            )
        }
    }

    private fun acceptInvitation(notification: NotificationModel) = _scope.launch {
        val itemIndex = _notifications
            .value
            .indexOfFirst { it.id == notification.id }

        Log.d(TAG, "rejectInvitation: before - itemIndex = $itemIndex ... size = ${_notifications.value.size}")
        if (itemIndex != -1) {
            _notifications.value.removeAt(itemIndex)
        }
        Log.d(TAG, "rejectInvitation: before - itemIndex = $itemIndex ... size = ${_notifications.value.size}")

        launch(Dispatchers.Main) {
            _eventFlow.emit(
                UiEvent.ShowToast(
                    UiText.StringResource(R.string.successfully_updated)
                )
            )
        }
    }

    sealed class UiEvent {
        data class ShowToast(val value: UiText): UiEvent()
        data object NavigateBack: UiEvent()
    }

}