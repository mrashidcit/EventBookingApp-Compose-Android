package com.rashidsaleem.eventbookingapp.presentation.signIn

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
    val rememberMeCheck: Boolean = false,
    val isLoading: Boolean = false,
)
