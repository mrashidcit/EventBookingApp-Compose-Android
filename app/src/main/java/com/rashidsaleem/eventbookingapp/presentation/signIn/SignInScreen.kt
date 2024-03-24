package com.rashidsaleem.eventbookingapp.presentation.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun SignInScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "SignIn Screen"
        )
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    EventBookingAppTheme {
        Surface {
            SignInScreen()
        }
    }
}

