package com.rashidsaleem.eventbookingapp.presentation.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.common.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel() {

    private val _uiState: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    fun onEvent(event: SignInEvent) {
        when(event) {
            is SignInEvent.UpdateEmailValue -> updateEmail(event.value)
            is SignInEvent.UpdatePasswordValue -> updatePassword(event.value)
            is SignInEvent.UpdatePasswordVisibility -> updatePasswordVisibility(event.value)
            is SignInEvent.UpdateRememberMeCheck -> updateRememberMeCheck(event.value)
            SignInEvent.SignInOnClick -> signInOnClick()
            SignInEvent.SignInWithFacebookOnClick -> signInWithFaebookOnClick()
            SignInEvent.SignInWithGoogleOnClick -> signInWithGoogleOnClick()
            SignInEvent.SignUpOnClick -> signUpOnClick()
            is SignInEvent.NavigateNext -> navigateNext(event.route)
        }
    }

    private fun navigateNext(route: String) = viewModelScope.launch {
        _eventFlow.emit(UiEvent.NavigateNext(route))
    }

    private fun signUpOnClick() = viewModelScope.launch {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.signUp))
    }

    private fun signInWithGoogleOnClick() {
        TODO("Not yet implemented")
    }

    private fun signInWithFaebookOnClick() {
        TODO("Not yet implemented")
    }

    private fun signInOnClick() = viewModelScope.launch {
        updateIsLoading(true)
        delay(4000L)
        updateIsLoading(false)
        _eventFlow.emit(UiEvent.NavigateNext(Routes.home))
    }

    private fun updateIsLoading(value: Boolean) {
        _uiState.update {
            it.copy(
                isLoading = value
            )
        }
    }

    private fun updateRememberMeCheck(value: Boolean) {
        _uiState.update {
            it.copy(
                rememberMeCheck = value
            )
        }
    }

    private fun updatePasswordVisibility(value: Boolean) {
        _uiState.update {
            it.copy(
                passwordVisibility = value
            )
        }
    }

    private fun updatePassword(value: String) {
        _uiState.update {
            it.copy(
                password = value
            )
        }
    }

    private fun updateEmail(value: String) {
        _uiState.update {
            it.copy(
                email = value
            )
        }
    }


    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
    }

}