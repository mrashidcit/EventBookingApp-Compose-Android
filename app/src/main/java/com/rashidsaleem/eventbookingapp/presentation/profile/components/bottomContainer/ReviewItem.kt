package com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.DateUtil
import com.rashidsaleem.eventbookingapp.domain.models.ReviewModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray28
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Yellow1

@Composable
fun ReviewItem(
    review: ReviewModel,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(review.profileImage)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_person),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.9f)
            ) {
                AppText(
                    text = review.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    lineHeight = 34.sp,
                )
                Row {

                    for(i in 1..review.rating) {
                        Icon(
                            modifier = Modifier.size(19.dp),
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Yellow1,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(7.dp))
                AppText(
                    text = review.comment,
                    fontSize = 15.sp,
                    color = Color.Black,
                    lineHeight = 25.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        AppText(
            modifier = Modifier.align(Alignment.TopEnd),
            text = review.getDateStringForDisplay(),
            fontSize = 15.sp,
            color = Gray28,
            lineHeight = 25.sp,
        )
    }
}

@Preview
@Composable
fun ReviewItemPreview() {
    EventBookingAppTheme {
        Surface {
            val review = remember {
                ReviewModel.dummyReviews()[0]
            }
            ReviewItem(
                review = review
            )
        }
    }
}

