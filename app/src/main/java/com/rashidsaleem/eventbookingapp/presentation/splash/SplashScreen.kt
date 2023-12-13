package com.rashidsaleem.eventbookingapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.Routes
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateNext: (String) -> Unit,
) {


    LaunchedEffect(key1 = true) {
        delay(2000L)
        navigateNext(Routes.onboarding)
    }


    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (logoAndTextContainer, topRightCircle,
            bottomLeftCircle, bottomRightCircle) = createRefs()

        // Top-Right Circle
        Image(
            modifier = Modifier
                .constrainAs(topRightCircle) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.img_top_right_background_circle),
            contentDescription = null
        )

        // Bottom-Left Circle
        Image(
            modifier = Modifier
                .constrainAs(bottomLeftCircle) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(id = R.drawable.img_bottom_left_background_circle),
            contentDescription = null
        )

        // Bottom-Right Circle
        Image(
            modifier = Modifier
                .constrainAs(bottomRightCircle) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(id = R.drawable.img_bottom_right_background_circle),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(logoAndTextContainer) {
                    this.centerVerticallyTo(parent)
                }
            ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = Modifier
                    .padding(bottom = 7.5.dp),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.img_venthub_text),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    EventBookingAppTheme {
        Surface {
            SplashScreen() {

            }
        }
    }
}

