package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend

import com.rashidsaleem.eventbookingapp.domain.models.InviteFriendModel

sealed class InviteFriendEvent {
    data class UpdateSearchQuery(val value: String): InviteFriendEvent()
    data class ItemOnClick(val item: InviteFriendModel): InviteFriendEvent()
    object Invite: InviteFriendEvent()

}