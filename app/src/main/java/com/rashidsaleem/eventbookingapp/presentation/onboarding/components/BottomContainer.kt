package com.rashidsaleem.eventbookingapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingEnum
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingEvent
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingUiState
import com.rashidsaleem.eventbookingapp.presentation.onboarding.previewOnboardingUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun BottomContainer(
    uiState: OnboardingUiState,
    onEvent: (OnboardingEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(
                color = Blue1,
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 48.dp,
                )
            )
            .padding(
                top = 40.dp, bottom = 37.dp,
                start = 40.dp, end = 39.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = uiState.titleResId) ,
            fontFamily = airbnbCerealFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            lineHeight = 34.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = uiState.descriptionResId),
            fontFamily = airbnbCerealFontFamily,
            fontSize = 15.sp,
            lineHeight = 25.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(43.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.clickable {

                },
                text = stringResource(id = R.string.skip),
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 34.sp,
                color = Color.White.copy(0.50f),
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        color = Color.White.copy(
                            if (uiState.onboardingEnum == OnboardingEnum.Onboarding1)
                                1f
                            else
                                0.20f
                        ),
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        color = Color.White.copy(
                            if (uiState.onboardingEnum == OnboardingEnum.Onboarding2)
                                1f
                            else
                                0.20f
                        ),
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        color = Color.White.copy(
                            if (uiState.onboardingEnum == OnboardingEnum.Onboarding3)
                                1f
                            else
                                0.20f
                        ),
                        shape = CircleShape
                    )
            )

            Spacer(modifier = Modifier.weight(1f))


            Text(
                modifier = Modifier.clickable {
                    onEvent(OnboardingEvent.NextOnClick)
                },
                text = stringResource(id = R.string.next),
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 34.sp,
                color = Color.White,
            )

        }


    }
}

@Preview
@Composable
fun BottomContainerPreview() {
    EventBookingAppTheme {
        Surface {

            val uiState = remember {
                previewOnboardingUiState
            }

            BottomContainer(
                uiState = uiState,
                onEvent = {}
            )
        }
    }
}

