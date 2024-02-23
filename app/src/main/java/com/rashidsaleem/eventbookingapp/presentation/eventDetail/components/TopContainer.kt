package com.rashidsaleem.eventbookingapp.presentation.eventDetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.EventDetailEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue7
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun TopContainer(
    modifier: Modifier = Modifier,
    event: EventModel,
    onEvent: (EventDetailEvent) -> Unit,
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth(),
    ) {

        val (goingPersons) = createRefs()

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(244.dp),
            painter = painterResource(id = R.drawable.img_music_concert),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        TopAppBar(
            text = stringResource(id = R.string.event_details),
            trailingIconId = R.drawable.ic_bookmark,
            leadingIconOnClick = { onEvent(EventDetailEvent.NavigateBack) },
            trailingIconOnClick = { onEvent(EventDetailEvent.Bookmark(event)) }
        )
        // Going Persons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(30.dp),
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(30.dp),
                )
                .padding(vertical = 13.dp, horizontal = 14.dp)
                .constrainAs(goingPersons) {
                    bottom.linkTo(parent.bottom, -25.dp)
                }
            ,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
            ) {
                val first3Items = event.getFirst3Persons()
                first3Items.mapIndexed { index, item ->
                    Image(
                        modifier = Modifier
                            .padding(start = 21.dp * index)
                            .size(34.18.dp)
                            .clip(CircleShape)
                            .zIndex((3 - index) * 1f)
                        ,
                        painter = painterResource(id = item),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                }.reversed()
            }
            Spacer(modifier = Modifier.width(10.dp))
            AppText(
                modifier = Modifier.clickable { onEvent(EventDetailEvent.PlusGoingPersons(event)) },
                text = event.plusGoingPersonsLabel(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Blue7
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .background(
                    color = Blue,
                    shape = RoundedCornerShape(7.dp)
                )
                .padding(horizontal = 18.dp, vertical = 6.dp)
                .clickable { onEvent(EventDetailEvent.ShowInviteDialog(true)) }
            ) {
                AppText(
                    textResId = R.string.invite,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }


    }
}



@Preview
@Composable
fun TopContainerPreview() {
    EventBookingAppTheme {
        Surface {
            val event = remember {
                EventModel.dummyEvents()[0]
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
//                    .background(color = Color.Green)
                    .background(color = Color.White)
            ) {

            }
            TopContainer(
                event = event,
                onEvent = {}
            )
        }
    }
}

