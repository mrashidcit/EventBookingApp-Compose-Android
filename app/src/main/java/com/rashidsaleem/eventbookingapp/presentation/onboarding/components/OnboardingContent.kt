package com.rashidsaleem.eventbookingapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingEvent
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingUiState
import com.rashidsaleem.eventbookingapp.presentation.onboarding.previewOnboardingUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun OnboardingContent(
    uiState: OnboardingUiState,
    onEvent: (OnboardingEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = 15.5.dp,
                )
                .drawWithContent {
                     val colors = listOf(
                         Color.Transparent,
                         Color.Transparent,
                         Color.Transparent,
                         Color.Transparent,
                         Color.Transparent,
                         Color.White,
                     )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                    )
                }
            ,
            painter = painterResource(id = uiState.imageResId),
            contentDescription = null,
        )
        BottomContainer(
            uiState = uiState,
            onEvent = onEvent
        )
    }

}

@Preview
@Composable
fun OnboardingContentPreview() {
    EventBookingAppTheme {
        Surface {
            val uiState = remember {
                previewOnboardingUiState.copy(
                    imageResId = R.drawable.img_onboarding3
                )
            }

            OnboardingContent(
                uiState = uiState,
                onEvent = {

                }
            )
        }
    }
}

