package com.rashidsaleem.eventbookingapp.presentation.profile

import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.common.enums.DataState
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.domain.models.home.dummyInterests
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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
        val state = DataState.Completed
        _uiState.update {
            it.copy(
                user = user,
                userDataState = state,
            )
        }
    }

}