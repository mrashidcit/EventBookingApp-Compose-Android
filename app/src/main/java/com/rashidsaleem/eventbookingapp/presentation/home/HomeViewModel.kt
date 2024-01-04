package com.rashidsaleem.eventbookingapp.presentation.home

import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeContentEvent
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeTopContainerEvent
import com.rashidsaleem.eventbookingapp.presentation.home.states.HomeContentUiState
import com.rashidsaleem.eventbookingapp.presentation.home.states.HomeTopContainerUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {

    private val _scope = viewModelScope
    private val _topContainerUiState: MutableStateFlow<HomeTopContainerUiState> = MutableStateFlow(HomeTopContainerUiState())
    val topContainerUiState: StateFlow<HomeTopContainerUiState> = _topContainerUiState.asStateFlow()
    private val _homeContentUiState: MutableStateFlow<HomeContentUiState> = MutableStateFlow(HomeContentUiState())
    val homeContentUiState: StateFlow<HomeContentUiState> = _homeContentUiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow<UiEvent>()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    init {
        _scope.launch(Dispatchers.IO) {
            loadUpcomingEvents()
        }
    }

    private suspend fun loadUpcomingEvents() {
        showLoader(true)
        delay(2000L)
        _homeContentUiState.update {
            it.copy(
                upcomingEvents = EventModel.dummyEvents()
            )
        }
        showLoader(false)
    }

    fun topContainerOnEvent(event: HomeTopContainerEvent) {
        when (event) {
            HomeTopContainerEvent.CurrentLocationClick -> currentLocationOnClick()
            is HomeTopContainerEvent.HorizontalListItemClick -> horizontalItemOnClick(event.value)
            HomeTopContainerEvent.NotificationIconClick -> showNotifications()
            is HomeTopContainerEvent.SearchFilterContainerClick -> showSearchFilterContainer(event.value)
            HomeTopContainerEvent.SearchIconClick -> performSearch()
            is HomeTopContainerEvent.UpdateSearchFieldValue -> updateSearchQuery(event.value)
            else -> {}
        }
    }

    private fun currentLocationOnClick() {

    }

    private fun horizontalItemOnClick(value: HorizontalItemEnum) {

    }

    private fun showNotifications() = _scope.launch {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.notifications))
    }

    private fun showSearchFilterContainer(value: Boolean) {
        _topContainerUiState.update {
            it.copy(
                showSearchFilterContainer = value
            )
        }
    }

    private fun performSearch() {

    }

    private fun updateSearchQuery(value: String) {
        _topContainerUiState.update {
            it.copy(
                searchQuery = value
            )
        }
    }

    fun homeContentOnEvent(event: HomeContentEvent) {
        when (event) {
            HomeContentEvent.UpcomingEventSeeAll -> upcomingEventSeeAllOnClick()
            is HomeContentEvent.EventBookmarkOnClick -> eventBookmarkOnClick(event.value)
            is HomeContentEvent.EventCardOnClick -> eventCardOnClick(event.value)
            HomeContentEvent.InviteYourFriend -> inviteYourFriend()
            HomeContentEvent.NearbyYouSeeAll -> nearbyYouSeeAllOnClick()
        }
    }

    private fun nearbyYouSeeAllOnClick() = _scope.launch(Dispatchers.Main) {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.map))
    }

    private fun inviteYourFriend() {

    }

    private fun eventCardOnClick(value: EventModel) = _scope.launch(Dispatchers.Main) {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.eventDetail))
    }

    private fun eventBookmarkOnClick(value: EventModel) {

    }

    private fun upcomingEventSeeAllOnClick() = _scope.launch(Dispatchers.Main) {
        _eventFlow.emit(UiEvent.NavigateNext(Routes.events))
    }

    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
        object NavigateBack: UiEvent()
    }

}