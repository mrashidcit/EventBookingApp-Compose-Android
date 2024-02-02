package com.rashidsaleem.eventbookingapp.domain.models.home

data class UserModel(
    val firstName: String,
    val lastName: String,
    val pic: String,
    val following: Int,
    val followers: Int,
    val aboutMe: String,
    val interests: List<String>
) {
    fun getFullName(): String = ("$firstName $lastName")
}
