package com.rashidsaleem.eventbookingapp.presentation.home.components.eventCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black3
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue7
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray6
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.SunsetOrange

@Composable
fun EventCard() {
    Column(
        modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(18.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        ImageContainer()
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
                // Img 3
                Image(
                    modifier = Modifier
                        .padding(start = (16 * 2).dp)
                        .width(24.dp)
                        .height(19.43.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.img_going_3),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
                // Img 2
                Image(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(24.dp)
                        .height(19.43.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.img_going_2),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
                // Img 1
                Image(
                    modifier = Modifier
                        .width(24.dp)
                        .height(19.43.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.img_going_1),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            AppText(
                text = "+20 Going",
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
                text = "36 Guild Street London, UK",
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
            color = Color.Green,
        ) {
            EventCard()
        }
    }
}

