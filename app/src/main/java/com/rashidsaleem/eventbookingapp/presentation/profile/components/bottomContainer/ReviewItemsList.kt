package com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.domain.models.ReviewModel
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun ReviewItemsList(
    modifier: Modifier = Modifier,
    reviews: List<ReviewModel>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(reviews) { review ->
            ReviewItem(
                review = review
            )
        }
    }
}


@Preview
@Composable
fun ReviewItemsListPreview() {
    EventBookingAppTheme {
        Surface {
            val reviews = remember {
                ReviewModel.dummyReviews()
            }
            ReviewItemsList(
                modifier = Modifier
                    .fillMaxSize(),
                reviews = reviews,
            )
        }
    }
}