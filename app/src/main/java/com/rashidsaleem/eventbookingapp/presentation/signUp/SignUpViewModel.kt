package com.rashidsaleem.eventbookingapp.presentation.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {

    private val _uiState: MutableStateFlow<SignUpUiState> = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    fun onEvent(event: SignUpEvent) {
        when(event) {
            is SignUpEvent.UpdateFullNameValue -> updateFullName(event.value)
            is SignUpEvent.UpdateEmailValue -> updateEmail(event.value)
            is SignUpEvent.UpdatePasswordValue -> updatePassword(event.value)
            is SignUpEvent.UpdatePasswordVisibility -> updatePasswordVisibility(event.value)
            is SignUpEvent.UpdateConfirmPasswordValue -> updateConfirmPassword(event.value)
            is SignUpEvent.UpdateConfirmPasswordVisibility -> updateConfirmPasswordVisibility(event.value)
            is SignUpEvent.UpdateRememberMeCheck -> updateRememberMeCheck(event.value)
            SignUpEvent.SignUpOnClick -> signUpOnClick()
            SignUpEvent.SignInOnClick -> signInOnClick()
            SignUpEvent.SignInWithFacebookOnClick -> signInWithFaebookOnClick()
            SignUpEvent.SignInWithGoogleOnClick -> signInWithGoogleOnClick()
            SignUpEvent.BackButtonOnClick -> backButtonOnClick()
        }
    }

    private fun updateFullName(value: String) {
        _uiState.update {
            it.copy(
                fullName = value
            )
        }
    }

    private fun backButtonOnClick() = viewModelScope.launch {
        _eventFlow.emit(UiEvent.NavigateBack(""))
    }

    private fun updateConfirmPasswordVisibility(value: Boolean) {
        _uiState.update {
            it.copy(
                confirmPasswordVisibility = value
            )
        }
    }

    private fun updateConfirmPassword(value: String) {
        _uiState.update {
            it.copy(
                confirmPassword = value
            )
        }
    }

    private fun signUpOnClick() = viewModelScope.launch {
        updateIsLoading(true)
        delay(3000L)
        updateIsLoading(false)
        _eventFlow.emit(UiEvent.NavigateNext(Routes.codeVerification))
    }

    private fun signInWithGoogleOnClick() {
        TODO("Not yet implemented")
    }

    private fun signInWithFaebookOnClick() {
        TODO("Not yet implemented")
    }

    private fun signInOnClick() = viewModelScope.launch {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.signIn))
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
        data class NavigateBack(val route: String): UiEvent()
    }

}