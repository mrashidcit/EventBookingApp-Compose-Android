package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.events.EventsListUiEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray19

/**
 * @param modifier - when placing this component in Column then use .weight(1f) property
 * to assign available space to this List
 *
 */
@Composable
fun AppEventsList(
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 0.dp,
    eventsList: List<EventModel>,
    showBookmark: Boolean = true,
    showEventAddress: Boolean = true,
    onEvent: (EventsListUiEvent) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .background(color = Gray19)
            .padding(horizontalPadding),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(eventsList.size) { index ->
            val event = eventsList[index]
            EventItem(
                modifier = Modifier.fillMaxWidth(),
                showBookmark = showBookmark,
                showEventAddress = showEventAddress,
                bookMarkOnClick = {
                    onEvent(EventsListUiEvent.BookmarkOnClick(event))
                },
                itemOnClick = {
                    onEvent(EventsListUiEvent.EventItemOnClick(event))
                }
            )
        }
    }
}