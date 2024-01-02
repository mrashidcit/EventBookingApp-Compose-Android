package com.rashidsaleem.eventbookingapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.home.state.HomeTopContainerUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _scope = viewModelScope
    private val _topContainerUiState: MutableStateFlow<HomeTopContainerUiState> = MutableStateFlow(HomeTopContainerUiState())
    val topContainerUiState: StateFlow<HomeTopContainerUiState> = _topContainerUiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow<UiEvent>()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()
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

    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
        object NavigateBack: UiEvent()
    }

}