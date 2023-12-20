package com.rashidsaleem.eventbookingapp.presentation.codeVerification

sealed class CodeVerificationEvent {
    data class UpdateCodeValue1(val value: String): CodeVerificationEvent()
    data class UpdateCodeValue2(val value: String): CodeVerificationEvent()
    data class UpdateCodeValue3(val value: String): CodeVerificationEvent()
    data class UpdateCodeValue4(val value: String): CodeVerificationEvent()
    object NavigateBack: CodeVerificationEvent()
    object ContinueButtonOnClick: CodeVerificationEvent()
    object SendVerificationCode: CodeVerificationEvent()
    object SendVerificationCodeFirstTime: CodeVerificationEvent()
}