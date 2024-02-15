package com.rashidsaleem.eventbookingapp.domain.models

import com.rashidsaleem.eventbookingapp.common.DateUtil

data class ReviewModel(
    val id: Int,
    val name: String,
    val profileImage: String = "",
    val rating: Int,
    val date: Long,
    val comment: String,
) {

    fun getDateStringForDisplay(): String =
        DateUtil.toString(
            dateInMillieseconds = date,
            format = DateUtil.ddMMM,
        ) ?: ""

    companion object {
        fun dummyReviews(): ArrayList<ReviewModel> {
            val names = listOf<String>("Rocks Velkeinjen", "Angelina Zolly")
            val comments = listOf<String>(
                "Cinemas is the ultimate experience to see new movies in Gold Class or Vmax. Find a cinema near you.",
                "ABC Cinemas is seems better than XYZ Cinameas ultimate experience to see new movies in Gold Class or Vmax. Find a cinema near you.",
            )
            val ratings = listOf<Int>(2, 3, 4)
            val items = arrayListOf<ReviewModel>()
            for (i in 0..20) {
                items.add(
                    ReviewModel(
                        id = i + 1,
                        name = names.random(),
                        rating = ratings.random(),
                        comment = comments.random(),
                        date = System.currentTimeMillis(),
                    )
                )
            }
            return items
        }
    }
}



