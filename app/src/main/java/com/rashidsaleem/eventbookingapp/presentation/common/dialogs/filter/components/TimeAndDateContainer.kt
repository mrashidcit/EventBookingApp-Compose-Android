package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
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
fun TimeAndDateContainer() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppText(
            textResId = R.string.timeAndDate,
            fontSize = 16.sp,
            lineHeight = 34.sp,
            fontWeight = FontWeight.Medium,
            color = Black2,
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            content = {
            item {
                CustomButton(
                    textResId = R.string.today,
                ) {}
            }
            item {
                CustomButton(
                    textResId = R.string.tomorrow,
                    isSelected = true
                ) {}
            }
            item {
                CustomButton(
                    textResId = R.string.tomorrow,
                ) {}
            }
        }
        )
        Spacer(modifier = Modifier.height(14.dp))
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
            Icon(
                modifier = Modifier.size(width = 21.dp, height = 23.3.dp),
                painter = painterResource(id = R.drawable.ic_calendar_2),
                contentDescription = null,
                tint = Blue
            )
            Spacer(modifier = Modifier.width(13.dp))
            AppText(
                textResId = R.string.choose_from_calender,
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

@Composable
private fun CustomButton(
    @StringRes textResId: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .then(
            if (isSelected)
                Modifier
                    .background(
                        color = Blue,
                        shape = RoundedCornerShape(10.dp)
                    )
            else
                Modifier.border(
                    width = 1.dp,
                    color = Gray22,
                    shape = RoundedCornerShape(10.dp)
                )
        )
        .clickable { }
        .padding(start = 19.dp, end = 19.dp, top = 9.dp, bottom = 8.dp)
    ) {
        AppText(
            textResId = textResId,
            fontSize = 15.sp,
            lineHeight = 25.sp,
            color = if (isSelected) Color.White else Gray3
        )
    }
}

@Preview
@Composable
fun TimeAndDateContainerPreview() {
    EventBookingAppTheme {
        Surface {
            TimeAndDateContainer()
        }
    }
}

