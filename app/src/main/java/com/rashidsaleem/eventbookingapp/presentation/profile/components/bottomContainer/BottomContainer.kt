package com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.enums.ProfileTypeEnum
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.domain.models.home.dummyInterests
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileEvent
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun BottomContainer(
    modifier: Modifier = Modifier,
    uiState: ProfileUiState,
    onEvent: (ProfileEvent) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        when (uiState.profileType) {
            ProfileTypeEnum.My -> {
                AppText(
                    textResId = R.string.about_me,
                    fontSize = 18.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight.Medium,
                    color = Black2,
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            ProfileTypeEnum.Organizer -> {
                TabContainer(
                    tabItemEnum = uiState.selectedTab,
                    onEvent = onEvent
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        AboutContainer(uiState, onEvent)
        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Preview
@Composable
fun BottomContainerPreview(
    modifier: Modifier = Modifier,
) {
    EventBookingAppTheme {
        Surface {
            val uiState = remember {
                ProfileUiState(
                    user = UserModel(
                        firstName = "Rashid",
                        lastName = "Saleem",
                        pic = "",
                        following = 350,
                        followers = 346,
                        aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
                        interests = dummyInterests()
                    ),
                    profileType = ProfileTypeEnum.Organizer,
                )
            }
            BottomContainer(uiState = uiState, onEvent = {

            })
        }
    }
}

