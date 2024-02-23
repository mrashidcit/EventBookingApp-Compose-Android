package com.rashidsaleem.eventbookingapp.domain.models

data class InviteFriendModel(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val profilePic: String,
    val followers: Int,
    val isSelected: Boolean = false,
)

val previewInviteFriends = arrayListOf<InviteFriendModel>(
    InviteFriendModel(
        id = 1,
        firstName = "Aex",
        lastName = "Lee",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 2000
    ),
    InviteFriendModel(
        id = 2,
        firstName = "Micheal",
        lastName = "Ulasi",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 56
    ),
    InviteFriendModel(
        id = 3,
        firstName = "Cristofer",
        lastName = "",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 300,
        isSelected = true,
    ),
    InviteFriendModel(
        id = 4,
        firstName = "David",
        lastName = "Silbia",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 5000
    ),
    InviteFriendModel(
        id = 5,
        firstName = "Ashfak",
        lastName = "Sayem",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 402
    ),
    InviteFriendModel(
        id = 6,
        firstName = "Rocks",
        lastName = "Velkeinjen",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 893,
        isSelected = true,
    ),
    InviteFriendModel(
        id = 7,
        firstName = "Roman",
        lastName = "Kutepov",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 225
    ),
    InviteFriendModel(
        id = 8,
        firstName = "Cristofer",
        lastName = "Nolan",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 322
    ),
    InviteFriendModel(
        id = 9,
        firstName = "Jhon",
        lastName = "Wick",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 2000,
        isSelected = true,
    ),
    InviteFriendModel(
        id = 10,
        firstName = "Zenifero",
        lastName = "Bolex",
        profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        followers = 2000
    ),

)