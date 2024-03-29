package com.rashidsaleem.eventbookingapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.HorizontalListItemButton
import com.rashidsaleem.eventbookingapp.presentation.common.components.SearchFilterButton
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeTopContainerEvent
import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemEnum
import com.rashidsaleem.eventbookingapp.presentation.home.states.HomeTopContainerUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.AtomicTangerine
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue3
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray5
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.MountainMeadow
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.PictonBlue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopContainer(
    contentHorizontalPadding: Dp = 24.dp,
    topContainerUiState: HomeTopContainerUiState,
    onEvent: (HomeTopContainerEvent) -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {

        val (content, horizontalItemsList) = createRefs()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Blue3,
                    shape = RoundedCornerShape(
                        bottomStart = 33.dp,
                        bottomEnd = 33.dp
                    ),
                )
                .padding(horizontal = contentHorizontalPadding)
                .constrainAs(content) {

                }
        ) {
            // AppBar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(29.2.dp)
                        .clickable {
                            onEvent(HomeTopContainerEvent.MenuIconClick)
                        },
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    tint = Color.White,
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier
                            .clickable {
                                onEvent(HomeTopContainerEvent.CurrentLocationClick)
                            },
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = stringResource(id = R.string.currentLocation),
                            color = Color.White.copy(0.70f),
                            fontFamily = airbnbCerealFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                        )
                        Spacer(Modifier.width(3.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = "New York, USA",
                        color = Gray5,
                        fontFamily = airbnbCerealFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                    )
                }

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clickable {
                            onEvent(HomeTopContainerEvent.NotificationIconClick)
                        }
                        .background(color = Color.White.copy(0.10f), shape = CircleShape)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            // SearchBox
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp),
                value = topContainerUiState.searchQuery,
                onValueChange = {
                    onEvent(HomeTopContainerEvent.UpdateSearchFieldValue(it))
                },
                placeholder = {
                    Text(
                        text = "Search...",
                        fontFamily = airbnbCerealFontFamily,
                        fontSize = 12.03.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White.copy(0.30f),
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                leadingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp)
                                .clickable {
                                    onEvent(HomeTopContainerEvent.SearchIconClick)
                                },
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .height(20.dp)
                                .background(color = Blue4)
                        )
                    }
                },
                trailingIcon = {
                    SearchFilterButton() {
                        onEvent(HomeTopContainerEvent.SearchFilterContainerClick(true))
                    }
                }
            )
            Spacer(Modifier.height(26.dp))
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(horizontalItemsList) {
                    top.linkTo(content.bottom, -26.dp)
                },
            contentPadding = PaddingValues(horizontal = contentHorizontalPadding),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                HorizontalListItemButton(
                    icon = R.drawable.ic_sports,
                    stringResId = R.string.sports
                ) {
                    onEvent(
                        HomeTopContainerEvent
                            .HorizontalListItemClick(HorizontalItemEnum.Sports)
                    )
                }
            }
            item {
                HorizontalListItemButton(
                    icon = R.drawable.ic_music,
                    stringResId = R.string.music,
                    containerColor = AtomicTangerine,
                ) {
                    onEvent(
                        HomeTopContainerEvent
                            .HorizontalListItemClick(HorizontalItemEnum.Music)
                    )
                }
            }
            item {
                HorizontalListItemButton(
                    icon = R.drawable.ic_food,
                    stringResId = R.string.food,
                    containerColor = MountainMeadow
                ) {
                    onEvent(
                        HomeTopContainerEvent
                            .HorizontalListItemClick(HorizontalItemEnum.Food)
                    )
                }
            }
            item {
                HorizontalListItemButton(
                    icon = R.drawable.ic_art,
                    stringResId = R.string.art,
                    containerColor = PictonBlue
                ) {
                    onEvent(
                        HomeTopContainerEvent
                            .HorizontalListItemClick(HorizontalItemEnum.Art)
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun TopContainerPreview() {
    EventBookingAppTheme {
        Surface(color = Color.White) {
            val uiState = remember {
                HomeTopContainerUiState()
            }

            TopContainer(
                topContainerUiState = uiState
            ) {

            }
        }
    }
}



