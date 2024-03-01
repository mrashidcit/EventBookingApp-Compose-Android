package com.rashidsaleem.eventbookingapp.presentation.profile

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.common.enums.DataStateEnum
import com.rashidsaleem.eventbookingapp.common.enums.ProfileTypeEnum
import com.rashidsaleem.eventbookingapp.domain.models.ReviewModel
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.domain.models.home.dummyInterests
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
): BaseViewModel() {
    private val TAG = "ProfileViewModel"


    private val _scope = viewModelScope
    private val _uiState: MutableStateFlow<ProfileUiState> = MutableStateFlow(
        ProfileUiState(
            user = UserModel.emptyUser()
        )
    )
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    // Input Params
    var _userId: Int = -1
    var _profileType: ProfileTypeEnum = ProfileTypeEnum.My

    init {

    }

    fun initData() = _scope.launch {
        // Loading Profile Data
        Log.d(TAG, "userId = $_userId")
        val user = UserModel.dummyUsers()
            .firstOrNull() { it.id == _userId } ?: return@launch
        val events = if (_profileType == ProfileTypeEnum.Organizer)
            EventModel.dummyEvents()
        else
            listOf<EventModel>()
        val reviews = if (_profileType == ProfileTypeEnum.My)
            ReviewModel.dummyReviews()
        else
            listOf<ReviewModel>()

        val state = DataStateEnum.Completed
        _uiState.update {
            it.copy(
                user = user,
                userDataState = state,
                profileType = _profileType,
                events = events,
                reviews = reviews,
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

    private fun navigateBack() = _scope.launch(Dispatchers.Main) {
        _eventFlow.emit(UiEvent.NavigateBack)
    }

    private fun editProfile() {
    }

    private fun changeInterest() {

    }

    fun updateParams(params: Bundle) {
        _userId = params.getInt(AppConstants.KEY_PROFILE_ID) ?: -1
        _profileType = params
            .getSerializable(AppConstants.KEY_PROFILE_TYPE) as ProfileTypeEnum?
            ?: ProfileTypeEnum.My
    }

    sealed class UiEvent {
        data class NavigateNext(val route: String, val params: Bundle? = null): UiEvent()
        data object NavigateBack: UiEvent()
    }

}