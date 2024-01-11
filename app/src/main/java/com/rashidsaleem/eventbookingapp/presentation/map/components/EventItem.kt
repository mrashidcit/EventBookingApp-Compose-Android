package com.rashidsaleem.eventbookingapp.presentation.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray11
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Orange1

@Composable
fun EventItem(
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp
    Row(
        modifier = modifier
            .width((screenWidth * 0.85f).dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .zIndex(4f)
//            .border(
//                width = 1.dp,
//                color = Gray11,
//                shape = RoundedCornerShape(16.dp)
//            )
    ) {
        Image(
            modifier = Modifier
                .padding(
                    start = 9.dp,
                    top = 7.dp,
                    bottom = 7.dp,
                )
                .width(79.dp)
                .height(92.dp)
                .clip(RoundedCornerShape(8.dp))
            ,
            painter = painterResource(id = R.drawable.img_card1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(17.dp))
        Column(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 12.dp,
                    end = 14.89.dp,
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AppText(
                    text = "Wed, Apr 28 . 5:30 PM",
                    fontSize = 13.sp,
                    color = Blue,
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier
                        .width(16.11.dp)
                        .height(16.dp),
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = null,
                    tint = Orange1,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            AppText(
                text = "Jo Malone London's Mother's Day Presents",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ic_location_on),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(6.dp))
                AppText(
                    text = "Radius Gallery . Santa Cruz, CA",
                    fontSize = 13.sp,
                    color = Gray1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview
@Composable
fun HorizontalEventItem() {
    EventBookingAppTheme {
        Surface(
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            EventItem()
        }
    }
}

