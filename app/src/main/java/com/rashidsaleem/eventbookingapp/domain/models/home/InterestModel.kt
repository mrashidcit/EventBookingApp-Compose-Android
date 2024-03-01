package com.rashidsaleem.eventbookingapp.domain.models.home

import androidx.compose.ui.graphics.Color

data class InterestModel(
    val label: String,
    val color: Color
) {

}

fun dummyInterests(): List<InterestModel> {
    return listOf(
        InterestModel("Games Online", Color(0xFF6B7AED)),
        InterestModel("Concert", Color(0xFFEE544A)),
        InterestModel("Music", Color(0xFFFF8D5D)),
        InterestModel("Art", Color(0xFF7D67EE)),
        InterestModel("Movie", Color(0xFF29D697)),
        InterestModel("Others", Color(0xFF39D1F2)),
    )
}
