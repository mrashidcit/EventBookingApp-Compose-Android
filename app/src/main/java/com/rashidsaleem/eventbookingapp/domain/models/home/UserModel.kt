package com.rashidsaleem.eventbookingapp.domain.models.home

data class UserModel(
    val firstName: String,
    val lastName: String,
    val pic: String,
    val following: Int,
    val followers: Int,
    val aboutMe: String,
    val interests: List<InterestModel>
) {
    fun getFullName(): String = ("$firstName $lastName")

    companion object {
        fun emptyUser(): UserModel {
            return UserModel(
                firstName = "",
                lastName = "",
                pic = "",
                following = 0,
                followers = 0,
                aboutMe = "",
                interests = listOf()
            )
        }
    }
}
