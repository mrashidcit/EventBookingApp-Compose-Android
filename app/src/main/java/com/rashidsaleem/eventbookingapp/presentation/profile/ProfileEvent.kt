package com.rashidsaleem.eventbookingapp.presentation.profile

sealed class ProfileEvent {
    data object ReadMore: ProfileEvent()
    data object ChangeInterest: ProfileEvent()
    data object EditProfile: ProfileEvent()
    data object NavigateBack: ProfileEvent()
    data class TabItemOnClick(val value: TabItemEnum): ProfileEvent()
}