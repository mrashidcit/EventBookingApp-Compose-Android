package com.rashidsaleem.eventbookingapp.presentation.profile

import com.rashidsaleem.eventbookingapp.common.enums.DataStateEnum
import com.rashidsaleem.eventbookingapp.common.enums.ProfileTypeEnum
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel

data class ProfileUiState(
    val user: UserModel,
    val userDataState: DataStateEnum = DataStateEnum.Initial,
    val profileType: ProfileTypeEnum = ProfileTypeEnum.My,
    val selectedTab: TabItemEnum = TabItemEnum.ABOUT,
)

enum class TabItemEnum {
    ABOUT,
    EVENT,
    REVIEWS
}
