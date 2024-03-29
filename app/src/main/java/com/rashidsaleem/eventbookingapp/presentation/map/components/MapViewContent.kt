package com.rashidsaleem.eventbookingapp.presentation.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.HorizontalListItemButton
import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemEnum
import com.rashidsaleem.eventbookingapp.presentation.map.MapViewEvent
import com.rashidsaleem.eventbookingapp.presentation.map.MapViewState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue9
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray10
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.MountainMeadow
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.MountainMeadow1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Orange

@Composable
fun MapViewContent(
    uiState: MapViewState,
    onEvent: (MapViewEvent) -> Unit,
    ) {

//    val events = remember {
//        EventModel.dummyEvents()
//    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (topContainer, bottomContainer) = createRefs()
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_sample_map),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )

        // TopContainer
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TopAppBar(
                searchQuery = uiState.searchQuery,
                onEvent = onEvent,
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                item {
                    HorizontalListItemButton(
                        icon = R.drawable.ic_sports,
                        iconColor = Orange,
                        textColor = Gray10,
                        containerColor = Color.White,
                        stringResId = R.string.sports,
                    ) {
                        onEvent(
                            MapViewEvent.TopListItemOnClick(HorizontalItemEnum.Sports)
                        )
                    }
                }
                item {
                    HorizontalListItemButton(
                        icon = R.drawable.ic_music,
                        iconColor = Blue9,
                        textColor = Gray10,
                        containerColor = Color.White,
                        stringResId = R.string.music,
                    ) {
                        onEvent(
                            MapViewEvent.TopListItemOnClick(HorizontalItemEnum.Music)
                        )
                    }
                }
                item {
                    HorizontalListItemButton(
                        icon = R.drawable.ic_food,
                        iconColor = MountainMeadow,
                        textColor = Gray10,
                        containerColor = Color.White,
                        stringResId = R.string.food,
                    ) {
                        onEvent(
                            MapViewEvent.TopListItemOnClick(HorizontalItemEnum.Food)
                        )
                    }
                }
                item {
                    HorizontalListItemButton(
                        icon = R.drawable.ic_art,
                        iconColor = MountainMeadow1,
                        textColor = Gray10,
                        containerColor = Color.White,
                        stringResId = R.string.art,
                    ) {
                        onEvent(
                            MapViewEvent.TopListItemOnClick(HorizontalItemEnum.Art)
                        )
                    }
                }
            }
        }

        // Bottom Container
        Box(
            modifier = Modifier
                .constrainAs(bottomContainer) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            EventsList(
                events = uiState.events,
                onEvent = onEvent,
            )
        }
    }
}

@Preview
@Composable
fun MapViewContentPreview() {
    EventBookingAppTheme {
        Surface {

            val uiState = remember {
                MapViewState()
            }

            MapViewContent(
                uiState = uiState,
                onEvent = { }
            )
        }
    }
}

