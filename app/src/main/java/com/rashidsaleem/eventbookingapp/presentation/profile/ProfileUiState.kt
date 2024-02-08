package com.rashidsaleem.eventbookingapp.presentation.profile

import com.rashidsaleem.eventbookingapp.common.enums.DataState
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel

data class ProfileUiState(
    val user: UserModel,
    val userDataState: DataState = DataState.Initial
)
