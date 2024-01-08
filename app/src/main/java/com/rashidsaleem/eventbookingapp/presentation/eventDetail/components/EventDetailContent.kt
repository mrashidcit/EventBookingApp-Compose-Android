package com.rashidsaleem.eventbookingapp.presentation.eventDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.EventDetailEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import java.util.Calendar

@Composable
fun EventDetailContent(
    event: EventModel,
    onEvent: (EventDetailEvent) -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (topContainer, content, bottomContainer) = createRefs()


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .constrainAs(content) {
                    top.linkTo(topContainer.bottom)
                    bottom.linkTo(bottomContainer.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            ContentContainer(
                event = event,
                onEvent = onEvent
                )
        }
        TopContainer(
            modifier = Modifier.constrainAs(topContainer) {
                top.linkTo(parent.top)
            },
            event = event,
            onEvent = onEvent
        )
        BottomContainer(
            modifier = Modifier
                .constrainAs(bottomContainer) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            onEvent(EventDetailEvent.BuyTicket(event))
        }
    }
}

@Preview
@Composable
fun EventDetailContentPreview() {
    val event = remember {
        val calendar = Calendar.getInstance()
        val date = calendar.apply {
            set(Calendar.DAY_OF_MONTH, 20)
        }.time
        val startTime = calendar.apply {
            set(Calendar.HOUR, 4)
            set(Calendar.MINUTE, 0)
            set(Calendar.AM_PM, Calendar.PM)
        }.time
        val endTime = calendar.apply {
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 0)
            set(Calendar.AM_PM, Calendar.PM)
        }.time

        EventModel.dummyEvents()[0].copy(
            venue = "Gala Convention Center",
            address = "36 Guild Street London, UK",
            date = date,
            startTime = startTime,
            endTime = endTime,
            title = "International Band Music Concert",
        )
    }

    EventBookingAppTheme {
        Surface {

            EventDetailContent(
                event = event,
                onEvent = {  },
            )
        }
    }
}

