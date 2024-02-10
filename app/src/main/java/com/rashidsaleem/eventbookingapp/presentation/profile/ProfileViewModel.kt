package com.rashidsaleem.eventbookingapp.presentation.profile

import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.common.enums.DataStateEnum
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.domain.models.home.dummyInterests
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel: BaseViewModel() {


    private val _scope = viewModelScope
    private val _uiState: MutableStateFlow<ProfileUiState> = MutableStateFlow(
        ProfileUiState(
            user = UserModel.emptyUser()
        )
    )
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        // Loading Profile Data
        val user = UserModel(
            firstName = "Rashid",
            lastName = "Saleem",
            pic = "",
            following = 350,
            followers = 346,
            aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
            interests = dummyInterests()
        )
        val state = DataStateEnum.Completed
        _uiState.update {
            it.copy(
                user = user,
                userDataState = state,
            )
        }
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            ProfileEvent.ChangeInterest -> changeInterest()
            ProfileEvent.EditProfile -> editProfile()
            ProfileEvent.NavigateBack -> navigateBack()
            ProfileEvent.ReadMore -> readMoreAboutMe()
            is ProfileEvent.TabItemOnClick -> TODO()
        }
    }

    private fun readMoreAboutMe() {
    }

    private fun navigateBack() {
    }

    private fun editProfile() {
    }

    private fun changeInterest() {

    }

}