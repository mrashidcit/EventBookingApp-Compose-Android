package com.rashidsaleem.eventbookingapp.presentation.signIn

sealed class SignInEvent {
    data class UpdateEmailValue(val value: String): SignInEvent()
    data class UpdatePasswordValue(val value: String): SignInEvent()
    data class UpdatePasswordVisibility(val value: Boolean): SignInEvent()
    data class UpdateRememberMeCheck(val value: Boolean): SignInEvent()
    object SignInOnClick: SignInEvent()
    object SignInWithGoogleOnClick: SignInEvent()
    object SignInWithFacebookOnClick: SignInEvent()
    object SignUpOnClick: SignInEvent()

}