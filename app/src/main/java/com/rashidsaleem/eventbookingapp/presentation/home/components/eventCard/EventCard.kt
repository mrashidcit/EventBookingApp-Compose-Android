package com.rashidsaleem.eventbookingapp.presentation.home.components.eventCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeContentEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue7
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray6

@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    event: EventModel,
    onEvent: (HomeContentEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(18.dp))
//            .shadow(
//                elevation = 8.dp,
//                shape = RoundedCornerShape(18.dp),
//                ambientColor = Black.copy(0.1f),
//                spotColor = Black.copy(0.1f),
//            )
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        ImageContainer(
            event = event,
            onEvent = onEvent,
        )
        Spacer(Modifier.height(14.dp))
        Box() {
            AppText(
                modifier = Modifier
                    .offset(
                        x = 0.dp,
                        y = 2.dp
                    )
                    .alpha(0.50f),
                text = "International Brand Mu....",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
            AppText(
                modifier = Modifier,
                text = "International Brand Mu....",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
        }
        Spacer(Modifier.height(8.1.dp))
        // Going
        Row(
//            modifier = Modifier.background(Color.Green),
            verticalAlignment = Alignment.Bottom,
        ) {
            Box(
            ) {
                val first3Items = event.getFirst3Persons()
                first3Items.mapIndexed { index, item ->
                    Image(
                        modifier = Modifier
                            .padding(start = 16.dp * index)
                            .width(24.dp)
                            .height(19.43.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = item),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                }.reversed()
//                // Img 3
//                Image(
//                    modifier = Modifier
//                        .padding(start = (16 * 2).dp)
//                        .width(24.dp)
//                        .height(19.43.dp)
//                        .clip(CircleShape),
//                    painter = painterResource(id = R.drawable.img_going_3),
//                    contentDescription = null,
//                    contentScale = ContentScale.FillBounds,
//                )
//                // Img 2
//                Image(
//                    modifier = Modifier
//                        .padding(start = 16.dp)
//                        .width(24.dp)
//                        .height(19.43.dp)
//                        .clip(CircleShape),
//                    painter = painterResource(id = R.drawable.img_going_2),
//                    contentDescription = null,
//                    contentScale = ContentScale.FillBounds,
//                )
//                // Img 1
//                Image(
//                    modifier = Modifier
//                        .padding(start = 16.dp * 0)
//                        .width(24.dp)
//                        .height(19.43.dp)
//                        .clip(CircleShape),
//                    painter = painterResource(id = R.drawable.img_going_1),
//                    contentDescription = null,
//                    contentScale = ContentScale.FillBounds,
//                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            AppText(
                text = event.plusGoingPersonsLabel(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Blue7
            )
        }
        Spacer(Modifier.height(8.1.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .width(16.dp)
                    .height(12.95.dp),
                painter = painterResource(id = R.drawable.ic_location_on),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(0.81.dp))
            AppText(
                text = "${event.address}",
                fontSize = 13.sp,
                color = Gray6,
            )
        }
        Spacer(Modifier.height((33 - 8).dp))
    }
}


@Preview
@Composable
fun EventCardPreview() {
    EventBookingAppTheme {
        Surface(
            modifier = Modifier,
            color = Color.Green,
        ) {
            val item = remember {
                EventModel.dummyEvents()[0]
            }

            EventCard(
                event = item,
                onEvent = { },
            )
        }
    }
}

