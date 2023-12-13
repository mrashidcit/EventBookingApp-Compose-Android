package com.rashidsaleem.eventbookingapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.common.Routes
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OnboardingViewModel: ViewModel() {

    private val _uiState: MutableStateFlow<OnboardingUiState> = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow<UiEvent>()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.Next -> next()
            OnboardingEvent.Skip -> skip()
        }

    }

    private fun skip() = viewModelScope.launch {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.signIn))
    }

    private fun next() = viewModelScope.launch {
        val currentIndex = _uiState.value.currentIndex
        if (currentIndex < 2) {
            _uiState.update {
                it.copy(
                    currentIndex = currentIndex+1
                )
            }
        } else {
            _eventFlow.emit(UiEvent.NavigateNext(Routes.signIn))
        }
    }


    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
    }
}