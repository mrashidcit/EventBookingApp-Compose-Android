package com.rashidsaleem.eventbookingapp.presentation.events.components

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.components.EventItem
import com.rashidsaleem.eventbookingapp.presentation.common.components.SearchBoxContainer
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.events.EventsUiComponent
import com.rashidsaleem.eventbookingapp.presentation.events.EventsUiEvent
import com.rashidsaleem.eventbookingapp.presentation.events.EventsUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray13
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray15
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray16
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray17
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray18
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray19
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsContent(
    uiState: EventsUiState,
    eventsList: List<EventModel>,
    onEvent: (EventsUiEvent) -> Unit,
) {

    val horizontalPadding = remember {
        24.dp
    }
    val buttonsHorizontalPadding = remember {
        52.dp
    }
    val buttonsVerticalPadding = remember {
        4.dp
    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (content, bottomButton) = createRefs()

        // Content
        Column(
            modifier = Modifier
                .background(color = Gray19)
                .constrainAs(content) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            TopAppBar(
                contentColor = Black2,
                leadingIconOnClick = {
                     onEvent(EventsUiEvent.NavigateBack)
                },
                text = stringResource(id = R.string.events),
                trailingIcons = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onEvent(EventsUiEvent.TopAppBarSearchIconOnClick)
                            },
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = Black2
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable {
                                onEvent(EventsUiEvent.TopAppBarMoreIconOnClick)
                            },
                        painter = painterResource(id = R.drawable.ic_more_vertical),
                        contentDescription = null,
                        tint = Black2
                    )
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            if (uiState.uiComponent == EventsUiComponent.Search) {
                SearchBoxContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    searchQuery = uiState.searchQuery,
                    searchIconColor = Blue,
                    verticalBarColor = Blue4,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        placeholderColor = Gray17
                    ),
                    filterContainerColor = Blue,
                    filterIconColor = Color.White,
                    filterTextColor = Gray18,
                    onValueChange = {
                        onEvent(EventsUiEvent.SearchQueryValueChange(it))
                    },
                    searchIconOnClick = {
                        onEvent(EventsUiEvent.SearchIconOnClick)
                    },
                    filterButtonOnClick = {
                        onEvent(EventsUiEvent.FilterIconOnClick)
                    },
                )
            }
            // TabsContainer
            if (uiState.uiComponent == EventsUiComponent.Upcoming ||
                uiState.uiComponent == EventsUiComponent.PastEvents ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .background(
                            color = Gray16,
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(
                            horizontal = 5.dp, vertical = 5.01.dp,
                        )
                ) {
                    // Upcoming Events
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (uiState.uiComponent == EventsUiComponent.Upcoming)
                                    Color.White
                                else
                                    Gray16,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .height(35.04.dp)
                            .weight(1f)
                            .clickable {
                                onEvent(EventsUiEvent.UpdateUiComponent(EventsUiComponent.Upcoming))
                            }
                            .padding(
                                horizontal = 10.dp
                            ),
                    ) {
                        AppText(
                            modifier = Modifier
                                .align(Alignment.Center),
                            text = stringResource(id = R.string.upcoming).uppercase(),
                            fontSize = 15.sp,
                            lineHeight = 25.sp,
                            color = if (uiState.uiComponent == EventsUiComponent.Upcoming)
                                Blue
                            else
                                Gray15,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    // Past Events
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (uiState.uiComponent == EventsUiComponent.PastEvents)
                                    Color.White
                                else
                                    Gray16,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .height(35.04.dp)
                            .weight(1f)
                            .clickable {
                                onEvent(EventsUiEvent.UpdateUiComponent(EventsUiComponent.PastEvents))
                            }
                            .padding(
//                        top = 5.87.dp, bottom = 4.17.dp,
                                horizontal = 10.dp
                            )
                    ) {
                        AppText(
                            modifier = Modifier
                                .align(Alignment.Center),
                            text = stringResource(id = R.string.past_events).uppercase(),
                            fontSize = 15.sp,
                            lineHeight = 25.sp,
                            color = if (uiState.uiComponent == EventsUiComponent.PastEvents)
                                Blue
                            else
                                Gray15,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
            when {
                (eventsList.isNotEmpty()) -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Gray19)
                            .weight(1f)
                            .padding(horizontalPadding),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        items(eventsList.size) { index ->
                            val event = eventsList[index]
                            EventItem(
                                modifier = Modifier.fillMaxWidth(),
                                bookMarkOnClick = {
                                    onEvent(EventsUiEvent.BookmarkOnClick(event))
                                },
                                itemOnClick = {
                                    onEvent(EventsUiEvent.EventItemOnClick(event))
                                }
                            )
                        }
                    }
                }
                else -> {
                    EmptyEvents()
                }
            }
        }

        // BottomButton
        if (uiState.uiComponent == EventsUiComponent.Upcoming ||
            uiState.uiComponent == EventsUiComponent.PastEvents) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = buttonsHorizontalPadding)
                    .padding(bottom = 33.dp)
                    .constrainAs(bottomButton) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    },
                onClick = {
                    onEvent(EventsUiEvent.UpdateUiComponent(EventsUiComponent.AllEvents))
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp
                ),
            ) {
                Row(
                    modifier = Modifier.padding(vertical = buttonsVerticalPadding),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.explore_events).uppercase(),
                        fontFamily = airbnbCerealFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                    Box(
                        modifier = Modifier
                            .background(color = Blue1, shape = CircleShape)
                            .size(30.dp)
                    ) {
                        Icon(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun EventsContentPreview() {
    EventBookingAppTheme {
        Surface {
            val uiState = remember {
                EventsUiState()
            }
            val eventsList = remember {
                listOf<EventModel>()
            }
            EventsContent(
                uiState = uiState,
                eventsList = eventsList,
                onEvent = {

                }
            )
        }
    }
}

