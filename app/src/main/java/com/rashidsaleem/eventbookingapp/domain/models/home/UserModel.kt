package com.rashidsaleem.eventbookingapp.domain.models.home

data class UserModel(
    val id: Int,
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
                id = 0,
                firstName = "",
                lastName = "",
                pic = "",
                following = 0,
                followers = 0,
                aboutMe = "",
                interests = listOf()
            )
        }

        fun dummyUsers(): List<UserModel> {
            return arrayListOf(
                UserModel(
                    id = 1,
                    firstName = "Rashid",
                    lastName = "Saleem",
                    pic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    following = 350,
                    followers = 346,
                    aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
                    interests = dummyInterests(),
                ),
                UserModel(
                    id = 2,
                    firstName = "Muhammad",
                    lastName = "Umar",
                    pic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    following = 350,
                    followers = 346,
                    aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
                    interests = dummyInterests(),
                ),
                UserModel(
                    id = 3,
                    firstName = "Sajid",
                    lastName = "Saleem",
                    pic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    following = 350,
                    followers = 346,
                    aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
                    interests = dummyInterests(),
                ),
            )
        }
    }
}
