package com.rashidsaleem.eventbookingapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeTopContainerEvent
import com.rashidsaleem.eventbookingapp.presentation.home.components.eventCard.EventCard
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeContentEvent
import com.rashidsaleem.eventbookingapp.presentation.home.states.HomeContentUiState
import com.rashidsaleem.eventbookingapp.presentation.home.states.HomeTopContainerUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    topContainerUiState: HomeTopContainerUiState,
    homeContentUiState: HomeContentUiState,
    topContainerOnEvent: (HomeTopContainerEvent) -> Unit,
    homeContentOnEvent: (HomeContentEvent) -> Unit,
) {

    val contentHorizontalPadding = remember {
        24.dp
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // Top Container
        TopContainer(
            topContainerUiState = topContainerUiState,
            onEvent = topContainerOnEvent
        )

        // Content
        Column(
            modifier = modifier
                .weight(1f)
//                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(21.58.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = contentHorizontalPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AppText(
                    textResId = R.string.upcomingEvents,
                    fontWeight = FontWeight.Medium,
                    color = Black2,
                    fontSize = 18.sp,
                )

                Row(
                    modifier = Modifier
                        .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AppText(
                        textResId = R.string.seeAll,
                        color = Gray1,
                        fontSize = 14.sp,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                        contentDescription = null,
                        tint = Gray1,
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
//                modifier = Modifier
//                    .background(color = Black.copy(0.01f)),
                contentPadding = PaddingValues(start = contentHorizontalPadding),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(homeContentUiState.upcomingEvents.size) {index ->
                    val item = homeContentUiState.upcomingEvents[index]
                    Box(
                        modifier = Modifier
                            .shadow(
                                12.dp,
                                shape = RoundedCornerShape(18.dp)
                            ),
                    ) {
                        EventCard(
                            event = item,
                            onEvent = homeContentOnEvent,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(29.dp))

            // InviteYourFriend container
            InviteYourFriendContainer(
                modifier = Modifier.padding(horizontal = contentHorizontalPadding)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Nearby You
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = contentHorizontalPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AppText(
                    textResId = R.string.nearbyYou,
                    fontWeight = FontWeight.Medium,
                    color = Black2,
                    fontSize = 18.sp,
                )

                Row(
                    modifier = Modifier
                        .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AppText(
                        textResId = R.string.seeAll,
                        color = Gray1,
                        fontSize = 14.sp,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                        contentDescription = null,
                        tint = Gray1,
                    )
                }
            }

        }
    }
}


@Preview
@Composable
fun HomeContentPreview() {
    EventBookingAppTheme {
        Surface {
            val homeTopContainerUiState = remember {
                HomeTopContainerUiState()
            }
            val homeContentUiState = remember {
                HomeContentUiState()
            }

            HomeContent(
                topContainerUiState = homeTopContainerUiState,
                homeContentUiState = homeContentUiState,
                topContainerOnEvent = {}
            ) {}
        }
    }
}

