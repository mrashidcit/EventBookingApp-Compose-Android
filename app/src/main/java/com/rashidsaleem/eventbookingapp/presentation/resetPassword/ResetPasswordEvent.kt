package com.rashidsaleem.eventbookingapp.presentation.resetPassword

sealed class ResetPasswordEvent {
    data class UpdateEmailValue(val value: String) : ResetPasswordEvent()
    object NavigateBack : ResetPasswordEvent()
    object SendButtonOnClick : ResetPasswordEvent()
}