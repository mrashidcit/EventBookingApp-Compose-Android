package com.rashidsaleem.eventbookingapp.presentation.resetPassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.common.Routes
import com.rashidsaleem.eventbookingapp.presentation.common.BaseEvent
import com.rashidsaleem.eventbookingapp.presentation.common.BaseUiState
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResetPasswordViewModel: BaseViewModel() {

    private val _uiState: MutableStateFlow<ResetPasswordUiState> = MutableStateFlow(ResetPasswordUiState())
    val uiState: StateFlow<ResetPasswordUiState> = _uiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    private val scope = viewModelScope

    fun onEvent(event: ResetPasswordEvent) {
        when (event) {
            ResetPasswordEvent.SendButtonOnClick -> sendButtonOnClick()
            is ResetPasswordEvent.UpdateEmailValue -> updateEmailValue(event.value)
            ResetPasswordEvent.NavigateBack -> navigateBack()
        }
    }

    private fun navigateBack() = scope.launch {
        _eventFlow.emit(UiEvent.NavigateBack)
    }

    private fun updateEmailValue(value: String) {
        _uiState.update {
            it.copy(
                email = value
            )
        }
    }

    private fun sendButtonOnClick() = scope.launch {

        baseOnEvent(BaseEvent.ShowLoader(true))
        delay(3000L)
        baseOnEvent(BaseEvent.ShowLoader(false))
        _eventFlow.emit(UiEvent.NavigateNext(Routes.home))
    }

    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
        object NavigateBack: UiEvent()
    }

}