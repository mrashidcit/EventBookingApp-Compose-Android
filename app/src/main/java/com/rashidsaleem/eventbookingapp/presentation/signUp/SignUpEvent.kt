package com.rashidsaleem.eventbookingapp.presentation.signUp

sealed class SignUpEvent {
    data class UpdateFullNameValue(val value: String): SignUpEvent()
    data class UpdateEmailValue(val value: String): SignUpEvent()
    data class UpdatePasswordValue(val value: String): SignUpEvent()
    data class UpdatePasswordVisibility(val value: Boolean): SignUpEvent()
    data class UpdateConfirmPasswordValue(val value: String): SignUpEvent()
    data class UpdateConfirmPasswordVisibility(val value: Boolean): SignUpEvent()

    data class UpdateRememberMeCheck(val value: Boolean): SignUpEvent()
    object BackButtonOnClick: SignUpEvent()
    object SignInOnClick: SignUpEvent()
    object SignInWithGoogleOnClick: SignUpEvent()
    object SignInWithFacebookOnClick: SignUpEvent()
    object SignUpOnClick: SignUpEvent()

}