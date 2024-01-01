package com.rashidsaleem.eventbookingapp.presentation.codeVerification

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.timer

class CodeVerificationViewModel: ViewModel() {

    private val TAG = "CodeVerificationViewModel"
    private val _uiState: MutableStateFlow<CodeVerificationUiState> = MutableStateFlow(CodeVerificationUiState())
    val uiState: StateFlow<CodeVerificationUiState> = _uiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    private val scope = viewModelScope
    private var _verificationCodeTimer: Timer? = null
    private var _sendVerificationCodeFirstTime: Boolean = false
    private val _verificationCodeDurationSeconds = 60

    init {
//        sendVerificationCode()

    }

    fun onEvent(event: CodeVerificationEvent) {
        when (event) {
            is CodeVerificationEvent.UpdateCodeValue1 -> updateCodeValue1(event.value)
            is CodeVerificationEvent.UpdateCodeValue2 -> updateCodeValue2(event.value)
            is CodeVerificationEvent.UpdateCodeValue3 -> updateCodeValue3(event.value)
            is CodeVerificationEvent.UpdateCodeValue4 -> updateCodeValue4(event.value)
            CodeVerificationEvent.NavigateBack -> navigateBack()
            CodeVerificationEvent.ContinueButtonOnClick -> continueButtonOnClick()
            CodeVerificationEvent.SendVerificationCode -> sendVerificationCode()
            CodeVerificationEvent.SendVerificationCodeFirstTime -> sendVerificationCodeFirstTime()
        }
    }

    private fun sendVerificationCodeFirstTime() {
        if (!_sendVerificationCodeFirstTime) {
            sendVerificationCode()
            _sendVerificationCodeFirstTime = true
        }
    }

    private fun sendVerificationCode() = scope.launch {

        if (_verificationCodeTimer != null) {
            _verificationCodeTimer?.cancel()
            _verificationCodeTimer = null
        }
//        updateTimerSeconds(60)
        updateTimerSeconds(_verificationCodeDurationSeconds)
        _verificationCodeTimer = timer(period = 1000L ) {
            _uiState.value.timerSeconds.let {timerSeconds ->
                if (timerSeconds <= 0) {
                    this.cancel()
                    _verificationCodeTimer = null
                }
                updateTimerSeconds(timerSeconds, 1)
            }
        }

    }

    private fun updateTimerSeconds(value: Int, decrementValue: Int = 0) {
        Log.d(TAG, "updateTimerSeconds: value >> $value")
        _uiState.update {
            it.copy(
                timerSeconds = value - decrementValue
            )
        }
    }

    private fun continueButtonOnClick() = scope.launch {

        _eventFlow.emit(UiEvent.NavigateNext(Routes.home))
    }

    private fun navigateBack() = scope.launch {
        _eventFlow.emit(UiEvent.NavigateBack)
    }

    private fun updateCodeValue1(value: String) {
        _uiState.update {
            it.copy(
                codeValue1 = value
            )
        }
    }
    private fun updateCodeValue2(value: String) {
        _uiState.update {
            it.copy(
                codeValue2 = value
            )
        }
    }
    private fun updateCodeValue3(value: String) {
        _uiState.update {
            it.copy(
                codeValue3 = value
            )
        }
    }
    private fun updateCodeValue4(value: String) {
        _uiState.update {
            it.copy(
                codeValue4 = value
            )
        }
    }


    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
        object NavigateBack: UiEvent()
    }
}