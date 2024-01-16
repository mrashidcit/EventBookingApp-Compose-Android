package com.rashidsaleem.eventbookingapp.presentation.map.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.EventItem
import com.rashidsaleem.eventbookingapp.presentation.map.MapViewEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun EventsList(
    events: List<EventModel>,
    onEvent: (MapViewEvent) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        contentPadding = PaddingValues(
            start = 25.dp,
            bottom = 20.dp,
            top = 20.dp,
        ),
        content = {
            items(events.size) {index ->
                val item = events[index]
                EventItem(
//                    event = item
                    modifier = Modifier
                        .width((screenWidth * 0.85f).dp),
                    bookMarkOnClick = {
                        onEvent(MapViewEvent.EventBookMark(item))
                    },
                    itemOnClick = {
                        onEvent(MapViewEvent.EventListItemOnClick(item))
                    }
                )
            }
        },
    )
}

@Preview
@Composable
fun EventsListPreview() {
    EventBookingAppTheme {
        Surface(
            color = Color.Green,
            modifier = Modifier.fillMaxSize()
        ) {
            
            val events = remember {
                EventModel.dummyEvents()
            }

            EventsList(
                events = events,
                onEvent = {}
            )
        }
    }
}

