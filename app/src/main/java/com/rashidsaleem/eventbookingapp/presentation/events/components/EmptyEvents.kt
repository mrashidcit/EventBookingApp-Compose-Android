package com.rashidsaleem.eventbookingapp.presentation.events.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray15
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray16
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun EmptyEvents() {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (topTabs, content, bottomButton) = createRefs()

        // Content
        Column(
            modifier = Modifier
                .constrainAs(content) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(202.dp),
                painter = painterResource(id = R.drawable.ic_calendar_for_no_events),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(31.dp))
            AppText(
                modifier = Modifier
                    .padding(horizontal = 50.dp),
                textResId = R.string.no_upcoming_event,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.64.dp))
            AppText(
                modifier = Modifier
                    .padding(horizontal = 50.dp),
                text = "Lorem ipsum is a placeholder text commonly",
                fontSize = 16.sp,
                lineHeight = 25.sp,
                color = Gray1,
                textAlign = TextAlign.Center
            )

        }

    }
}

@Preview
@Composable
fun EmptyEventsPreview() {
    EventBookingAppTheme {
        Surface {
            EmptyEvents()
        }
    }
}

