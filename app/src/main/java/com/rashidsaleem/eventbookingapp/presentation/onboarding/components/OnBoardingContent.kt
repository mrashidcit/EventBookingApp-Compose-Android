package com.rashidsaleem.eventbookingapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.OnboardingModel
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnBoardingScreen
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingEvent
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun OnBoardingContent(
    uiState: OnboardingUiState,
    onEvent :(OnboardingEvent) -> Unit,
    ) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            modifier = Modifier
                .padding(top = 40.dp)
                .weight(1f)
                .graphicsLayer {
                    alpha = 0.99f
                }
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
                        blendMode = BlendMode.DstOut
                    )
                },
            painter = painterResource(id = uiState.getCurrentItem().imageResId),
            contentDescription = null,
        )

        // Bottom Container
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Blue,
                    shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp),
                )
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = stringResource(id = uiState.getCurrentItem().titleResId),
                color = Color.White,
                fontSize = 22.sp,
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = uiState.getCurrentItem().descriptionResId),
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(48.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier
                        .clickable (
                            enabled = uiState.shouldEnableSkipButton()
                        ) {
                            onEvent.invoke(OnboardingEvent.Skip)
                        },
                    text = stringResource(id = R.string.skip),
                    color = Color.White.copy(
                        if (uiState.shouldEnableSkipButton())
                            1f
                        else
                            0.50f
                    ),
                    fontSize = 18.sp,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Medium
                )

                Row(

                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.White.copy(0.20f),
                                shape = CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.White.copy(0.20f),
                                shape = CircleShape
                            )
                    )
                }

                Text(
                    modifier = Modifier
                        .clickable {
                            onEvent.invoke(OnboardingEvent.Next)
                        },
                    text = stringResource(id = R.string.next),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
fun OnBoardingContentPreview() {
    EventBookingAppTheme {

        val uiState by remember {
            mutableStateOf(
                OnboardingUiState(
                    items = OnboardingModel.defaultItems(),
                )
            )
        }

        Surface {
            OnBoardingContent(
                uiState = uiState,
                onEvent = { }
            )
        }
    }
}