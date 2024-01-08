package com.rashidsaleem.eventbookingapp.presentation.eventDetail.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.DateUtil
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.EventDetailEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black6
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray7
import java.util.Calendar

@Composable
fun ContentContainer(
    event: EventModel,
    onEvent: (EventDetailEvent) -> Unit,
) {
    val horizontalPadding = remember {
        24.dp
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        AppText(
            text = event.title,
            fontSize = 35.sp,
            color = Black2,
            lineHeight = 45.sp,
        )
        Spacer(modifier = Modifier.height(18.dp))

        Item(
            iconResId = R.drawable.ic_calendar_2,
            title = "${DateUtil.toString(date = event.date, format = DateUtil.ddMMMCommayyyy)}",
            subTitle = event.getStartAndEndTimeStringForDisplay()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Item(
            iconResId = R.drawable.ic_location_on_with_shadow,
            iconTint = Color.Unspecified,
            title = event.venue,
            subTitle = event.address,
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Profile Info Container
        ProfileInfoContainer(
            onEvent = onEvent
        )

        Spacer(modifier = Modifier.height(21.dp))
        AppText(
            textResId = R.string.about_event,
            fontSize = 18.sp,
            color = Black2.copy(0.84f),
            fontWeight = FontWeight.Medium,
            lineHeight = 34.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        AppText(
            text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            fontSize = 16.sp,
            lineHeight = 28.sp,
        )

    }
}

@Composable
private fun ProfileInfoContainer(
    onEvent: (EventDetailEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable { onEvent(EventDetailEvent.OrganizerProfileDetail) },
            painter = painterResource(id = R.drawable.img_user_ashfak),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(13.dp))
        Column(
            modifier = Modifier.weight(1f)
                .clickable { onEvent(EventDetailEvent.OrganizerProfileDetail) }
        ) {
            AppText(
                text = "Ashfak Sayem",
                color = Black6,
                fontSize = 15.sp,
                lineHeight = 25.sp,
            )
            AppText(
                text = "Organizer",
                color = Gray7,
                fontSize = 12.sp,
            )

        }
        Box(
            modifier = Modifier
                .background(
                    color = Blue.copy(0.12f),
                    shape = RoundedCornerShape(7.dp)
                )
                .clickable { onEvent(EventDetailEvent.Follow) }
        ) {
            AppText(
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
                text = stringResource(id = R.string.follow),
                color = Blue,
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
private fun Item(
    @DrawableRes iconResId: Int,
    iconTint: Color = Blue,
    title: String,
    subTitle: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Blue.copy(0.10f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(9.dp)
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = iconTint,
            )
        }
        Spacer(modifier = Modifier.width(13.dp))
        Column {
            AppText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Black2.copy(0.84f),
            )
            Spacer(modifier = Modifier.height(1.dp))
            AppText(
                modifier = Modifier
                    .padding(start = 1.dp, top = 1.dp),
                text = subTitle,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Gray1,
            )
        }
    }
}

@Preview
@Composable
fun ContentContainerPreview() {
    EventBookingAppTheme {
        Surface {

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

                EventModel(
                    venue = "Gala Convention Center",
                    address = "36 Guild Street London, UK",
                    date = date,
                    startTime = startTime,
                    endTime = endTime,
                    title = "International Band Music Concert",
                )
            }

            ContentContainer(
                event = event,
                onEvent = {}
            )
        }
    }
}

