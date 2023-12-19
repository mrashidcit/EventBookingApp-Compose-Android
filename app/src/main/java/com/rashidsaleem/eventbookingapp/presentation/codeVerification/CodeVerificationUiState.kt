package com.rashidsaleem.eventbookingapp.presentation.codeVerification

import androidx.compose.runtime.Composable

data class CodeVerificationUiState(
    val phoneNo: String = "",
    val codeValue1: String = "",
    val codeValue2: String = "",
    val codeValue3: String = "",
    val codeValue4: String = "",
    val timerSeconds: Int = 0,
) {
    fun getTimerSecondsForDisplay(): String {
        return when {
            (timerSeconds <= 9) -> "0$timerSeconds"
            else -> "$timerSeconds"
        }
    }
}