package com.rashidsaleem.eventbookingapp.presentation.eventDetail

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.common.AppUtil
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EventDetailViewModel @Inject constructor(
        savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _scope = viewModelScope
    private val _uiState: MutableStateFlow<EventDetailState> = MutableStateFlow<EventDetailState>(EventDetailState())
    val uiState: StateFlow<EventDetailState> = _uiState.asStateFlow()

    init {
        savedStateHandle.get<EventModel>(AppConstants.KEY_EVENT_MODEL)?.let {event ->

            _uiState.update {
                it.copy(
                    event = event
                )
            }

        }
    }

    fun onEvent(event: EventDetailEvent) {
        when (event) {
            is EventDetailEvent.Bookmark -> bookMark(event.event)
            is EventDetailEvent.BuyTicket -> buyTicket(event.event)
            EventDetailEvent.Follow -> followOrganizer()
            is EventDetailEvent.Invite -> inviteFriend(event.event)
            EventDetailEvent.NavigateBack -> navigateBack()
            EventDetailEvent.OrganizerProfileDetail -> organizerProfileDetail()
            is EventDetailEvent.PlusGoingPersons -> plusGoingPersons(event.event)
        }
    }


    private fun inviteFriend(event: EventModel) {

    }

    private fun followOrganizer() {

    }

    private fun buyTicket(event: EventModel) = _scope.launch {

    }

    private fun bookMark(event: EventModel) = _scope.launch {

        showLoader(true)
        delay(3000L)
        showLoader(false)
        AppUtil.showToast(
            AppUtil.getStringResource(R.string.successfully_bookmarked)
        )

    }

    private fun navigateBack() {

    }

    private fun organizerProfileDetail() {

    }

    private fun plusGoingPersons(event: EventModel) {

    }




    sealed class UiEvent {
        data object NavigateBack: UiEvent()
        data class NavigateNext(val route: String, val params: Bundle?): UiEvent()
    }
}