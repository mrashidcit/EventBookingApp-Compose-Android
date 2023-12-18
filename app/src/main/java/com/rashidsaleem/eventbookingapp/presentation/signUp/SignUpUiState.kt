package com.rashidsaleem.eventbookingapp.presentation.signUp

data class SignUpUiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
    val confirmPassword: String = "",
    val confirmPasswordVisibility: Boolean = false,
    val rememberMeCheck: Boolean = false,
    val isLoading: Boolean = false,
)
