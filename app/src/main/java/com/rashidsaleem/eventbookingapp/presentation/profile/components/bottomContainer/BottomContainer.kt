package com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.enums.ProfileTypeEnum
import com.rashidsaleem.eventbookingapp.domain.models.ReviewModel
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.domain.models.home.dummyInterests
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppEventsList
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.events.EventsListUiEvent
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileEvent
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileUiState
import com.rashidsaleem.eventbookingapp.presentation.profile.TabItemEnum
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black
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
                AboutContainer(uiState, onEvent)
            }

            ProfileTypeEnum.Organizer -> {
                TabContainer(
                    tabItemEnum = uiState.selectedTab,
                    onEvent = onEvent
                )
                Spacer(modifier = Modifier.height(20.dp))
                when (uiState.selectedTab) {
                    TabItemEnum.ABOUT -> AboutContainer(uiState, onEvent)
                    TabItemEnum.EVENT -> {
                        if (uiState.events.isEmpty()) {
                            EmptyBox(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            )
                        } else {
                            AppEventsList(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                eventsList = uiState.events,
                                showBookmark = false,
                                showEventAddress = false,
                                onEvent = { event ->
                                    when (event) {
                                        is EventsListUiEvent.BookmarkOnClick -> {}
                                        is EventsListUiEvent.EventItemOnClick -> {

                                        }
                                    }
                                }
                            )
                        }
                    }
                    TabItemEnum.REVIEWS -> {
                        if (uiState.reviews.isEmpty()) {
                            EmptyBox(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            )
                        } else {
                            ReviewItemsList(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                ,
                                reviews = uiState.reviews,
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun EmptyBox(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        AppText(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Empty!",
            fontSize = 16.sp,
            color = Black
        )
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
                        id = 1,
                        firstName = "Rashid",
                        lastName = "Saleem",
                        pic = "",
                        following = 350,
                        followers = 346,
                        aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
                        interests = dummyInterests()
                    ),
                    profileType = ProfileTypeEnum.My,
                    selectedTab = TabItemEnum.REVIEWS,
//                    events = EventModel.dummyEvents(),
//                    reviews = ReviewModel.dummyReviews(),
                    events = listOf(),
                    reviews = listOf(),
                )
            }
            BottomContainer(uiState = uiState, onEvent = {

            })
        }
    }
}

