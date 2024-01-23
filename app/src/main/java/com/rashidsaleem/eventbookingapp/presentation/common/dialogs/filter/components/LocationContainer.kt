package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray22
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray3

@Composable
fun LocationContainer() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppText(
            textResId = R.string.location,
            fontSize = 16.sp,
            lineHeight = 34.sp,
            fontWeight = FontWeight.Medium,
            color = Black2,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Gray22,
                    shape = RoundedCornerShape(10.dp),
                )
                .padding(
                    horizontal = 14.dp,
                    vertical = 9.dp,
                )
            ,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(11.89.dp))
                    .border(
                        width = 7.dp,
                        color = Blue.copy(0.15f),
                        shape = RoundedCornerShape(11.89.dp)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_location_outlined),
                    contentDescription = null,
                    tint = Blue
                )
            }
            Spacer(modifier = Modifier.width(13.dp))
            AppText(
                text = "New Yourk, USA",
                fontSize = 15.sp,
                lineHeight = 25.sp,
                color = Gray3,
            )
            Spacer(modifier = Modifier.width(14.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_forward_ios),
                contentDescription = null,
                tint = Blue,
            )
        }
    }
}

@Preview
@Composable
fun LocationContainerPreview() {
    EventBookingAppTheme {
        Surface {
            LocationContainer()
        }
    }
}

