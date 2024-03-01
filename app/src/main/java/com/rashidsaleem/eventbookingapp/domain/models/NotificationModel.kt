package com.rashidsaleem.eventbookingapp.domain.models

import java.util.Calendar

data class NotificationModel(
    val id: Int,
    val userId: Int,
    val userFullName: String,
    val userProfilePictureUrl: String,
    val type: NotificationTypeEnum = NotificationTypeEnum.StartedFollowingYou,
    val eventName: String? = null,
    val status: InviteStatusEnum = InviteStatusEnum.None,
    val date: Long,
) {

//    fun isInvitedToCurrentLoggedInUser(currentUserId: Int): Boolean {
//        return currentUserId == invitedToUserId
//    }
//
//    fun getInvitedToPersonName(currentUserId: Int): String {
//        return if (isInvitedToCurrentLoggedInUser(currentUserId)) {
//            "you"
//        } else {
//            invitedToUserFullName
//        }
//    }

    companion object {
        fun dummyNotifications(): ArrayList<NotificationModel> {
            val calendar = Calendar.getInstance()
            return arrayListOf(
                NotificationModel(
                    id = 1,
                    userId = 1,
                    userFullName = "David Siblia",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.Invite,
                    eventName = "London's Mother's",
                    date = calendar.timeInMillis
                ),
                NotificationModel(
                    id = 2,
                    userId = 2,
                    userFullName = "Adnan Safi",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.StartedFollowingYou,
                    eventName = null,
                    date = calendar.apply {
                        add(Calendar.MINUTE, 5)
                    }.timeInMillis
                ),
                NotificationModel(
                    id = 3,
                    userId = 3,
                    userFullName = "Joan Baker",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.Invite,
                    eventName = "Evening of Smooth Jazz",
                    date = calendar.apply {
                        add(Calendar.MINUTE, 15)
                    }.timeInMillis
                ),
                NotificationModel(
                    id = 4,
                    userId = 4,
                    userFullName = "Ronald C.Kinch",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.LikeYourEvents,
                    eventName = null,
                    date = calendar.apply {
                        add(Calendar.MINUTE, 40)
                    }.timeInMillis
                ),
                NotificationModel(
                    id = 5,
                    userId = 5,
                    userFullName = "Clara Tolson",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.JoinYourEvent,
                    eventName = "Event Gala Music Festival",
                    date = calendar.apply {
                        add(Calendar.HOUR, 8)
                    }.timeInMillis
                ),
                NotificationModel(
                    id = 6,
                    userId = 6,
                    userFullName = "Jennifer Fritz",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.Invite,
                    eventName = "Internation Kids Safe",
                    date = calendar.apply {
                        add(Calendar.HOUR, 24 * 2)
                    }.timeInMillis
                ),
                NotificationModel(
                    id = 7,
                    userId = 7,
                    userFullName = "Eric G. Prickett",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.StartedFollowingYou,
                    eventName = null,
                    date = calendar.apply {
                        add(Calendar.HOUR, 24 * 1)
                    }.timeInMillis
                ),
            )
        }
    }

}



enum class NotificationTypeEnum {
    StartedFollowingYou,
    Invite,
    LikeYourEvents,
    JoinYourEvent,
}

enum class InviteStatusEnum {
    None,
    Accept,
    Reject,

}