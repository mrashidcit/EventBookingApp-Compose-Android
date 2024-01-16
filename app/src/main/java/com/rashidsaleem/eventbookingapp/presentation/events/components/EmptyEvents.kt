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

    val buttonsHorizontalPadding = remember {
        52.dp
    }
    val buttonsVerticalPadding = remember {
        4.dp
    }


    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (topTabs, content, bottomButton) = createRefs()

        // TopTabs
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(
                    color = Gray16,
                    shape = RoundedCornerShape(100.dp)
                )
                .padding(
                    horizontal = 5.dp, vertical = 5.01.dp,
                )
                .constrainAs(topTabs) {
                    top.linkTo(parent.top, 20.12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    centerHorizontallyTo(parent)
                }
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = if (true) Color.White else Gray16,
                        shape = RoundedCornerShape(100.dp)
                    )
                    .height(35.04.dp)
                    .weight(1f)
                    .padding(
//                        top = 5.87.dp, bottom = 4.17.dp,
                        horizontal = 10.dp
                    ),
            ) {
                AppText(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = stringResource(id = R.string.upcoming).uppercase(),
                    fontSize = 15.sp,
                    lineHeight = 25.sp,
                    color = if (true) Blue else Gray15,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Box(
                modifier = Modifier
                    .background(
                        color = if (false) Color.White else Gray16,
                        shape = RoundedCornerShape(100.dp)
                    )
                    .height(35.04.dp)
                    .weight(1f)
                    .padding(
//                        top = 5.87.dp, bottom = 4.17.dp,
                        horizontal = 10.dp
                    )
            ) {
                AppText(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = stringResource(id = R.string.past_events).uppercase(),
                    fontSize = 15.sp,
                    lineHeight = 25.sp,
                    color = if (false) Blue else Gray15,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

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


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = buttonsHorizontalPadding)
                .padding(bottom = 33.dp)
                .constrainAs(bottomButton) {
                       bottom.linkTo(parent.bottom)
                       start.linkTo(parent.start)
                       end.linkTo(parent.end)

                },
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue
            ),
            shape = RoundedCornerShape(14.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            ),
        ) {
            Row(
                modifier = Modifier.padding(vertical = buttonsVerticalPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.explore_events).uppercase(),
                    fontFamily = airbnbCerealFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
                Box(
                    modifier = Modifier
                        .background(color = Blue1, shape = CircleShape)
                        .size(30.dp)
                ) {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                    )
                }
            }
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

