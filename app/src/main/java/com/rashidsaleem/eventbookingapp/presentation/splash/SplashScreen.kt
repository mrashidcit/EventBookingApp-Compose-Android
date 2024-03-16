package com.rashidsaleem.eventbookingapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {

        // Top Right
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .height(209.dp),
            painter = painterResource(id = R.drawable.img_background_top_right),
            contentDescription = null,
        )

        // Bottom Right
        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .height(322.dp)
            ,
            painter = painterResource(id = R.drawable.img_background_bottom_right),
            contentDescription = null,
        )

        // Bottom Left
        Image(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .height(153.dp),
            painter = painterResource(id = R.drawable.img_background_bottom_left),
            contentDescription = null,
        )


        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_eventhub_splash),
            contentDescription = null,
        )

    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    EventBookingAppTheme {
        SplashScreen()
    }
}

