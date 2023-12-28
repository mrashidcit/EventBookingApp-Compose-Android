package com.rashidsaleem.eventbookingapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun EventCard() {
    ConstraintLayout(
        modifier = Modifier
    ) {
        Image(
            modifier = Modifier
                .width(218.dp)
                .height(132.dp),
            painter = painterResource(id = R.drawable.img_card1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
fun EventCardPreview() {
    EventBookingAppTheme {
        Surface {
            EventCard()
        }
    }
}

