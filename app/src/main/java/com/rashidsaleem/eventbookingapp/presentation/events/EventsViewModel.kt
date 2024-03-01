package com.rashidsaleem.eventbookingapp.presentation.events

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventsViewModel: BaseViewModel() {

    private val _scope = viewModelScope

    private val _uiState: MutableStateFlow<EventsUiState> = MutableStateFlow(EventsUiState())
    val uiState: StateFlow<EventsUiState> = _uiState.asStateFlow()

    private val _upcomingEvents: ArrayList<EventModel> = arrayListOf()
    private val _pastEvents: ArrayList<EventModel> = arrayListOf()

    private val _eventsListForDisplay: MutableStateFlow<List<EventModel>> = MutableStateFlow(listOf<EventModel>())
    val eventsListForDisplay: StateFlow<List<EventModel>> = _eventsListForDisplay.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    init {

        _upcomingEvents.addAll(EventModel.dummyEvents())
        _pastEvents.addAll(EventModel.dummyEvents().shuffled())

        _eventsListForDisplay.value = _upcomingEvents + _pastEvents

    }

    fun onEvent(event: EventsUiEvent) {
        when (event) {
            is EventsUiEvent.TopAppBarBackArrowIconOnClick -> topAppBarBackArrowOnClick()
            EventsUiEvent.TopAppBarMoreIconOnClick -> topAppBarMoreIconOnClick()
            EventsUiEvent.TopAppBarSearchIconOnClick -> topAppBarSearchIconOnClick()
            is EventsUiEvent.UpdateUiComponent -> updateUiComponent(event.value)
            EventsUiEvent.SearchIconOnClick -> searchIconOnClick()
            is EventsUiEvent.SearchQueryValueChange -> updateSearchQuery(event.value)
            EventsUiEvent.FilterIconOnClick -> filterIconOnCLick()
            is EventsUiEvent.BookmarkOnClick -> bookmarkOnClick(event.value)
            EventsUiEvent.NavigateBack -> navigateBack()
            is EventsUiEvent.EventItemOnClick -> eventItemOnClick(event.value)
        }
    }

    private fun eventItemOnClick(value: EventModel) = _scope.launch {
        val route = Routes.eventDetail
        val eventJson = try {
            Gson().toJson(value, EventModel::class.java)
        } catch (e: Exception) {
            ""
        }
        val params = bundleOf().apply {
            putString(AppConstants.KEY_EVENT_MODEL, eventJson)
        }
        navigateNext(route, params)
    }

    private fun navigateBack() = _scope.launch(Dispatchers.Main) {
        val uiComponent = _uiState.value.uiComponent
        when {
            (uiComponent == EventsUiComponent.Search ||
                    uiComponent == EventsUiComponent.AllEvents) ->
                        updateUiComponent(EventsUiComponent.Upcoming)
            else -> _eventFlow.emit(UiEvent.NavigateBack)
        }
    }

    private fun navigateNext(route: String, params: Bundle) = _scope.launch(Dispatchers.Main) {
        _eventFlow.emit(UiEvent.NavigateNext(route, params))
    }


    private fun bookmarkOnClick(value: EventModel) {

    }

    private fun filterIconOnCLick() {

    }

    private fun updateSearchQuery(value: String) {
        _uiState.update {
            it.copy(
                searchQuery = value
            )
        }
    }

    private fun searchIconOnClick() {
        val searchQuery = _uiState.value.searchQuery.trim()
        performSearch(searchQuery)
    }

    private fun performSearch(searchQuery: String) = _scope.launch(Dispatchers.Default) {
        val eventsList = _pastEvents  + _upcomingEvents
        _eventsListForDisplay.value = eventsList.filter {event ->
            event.title.contains(searchQuery)
        }
    }

    private fun updateUiComponent(value: EventsUiComponent) {
        _uiState.update {
            it.copy(
                uiComponent = value
            )
        }
    }

    private fun topAppBarSearchIconOnClick() {
        updateUiComponent(EventsUiComponent.Search)
    }

    private fun topAppBarMoreIconOnClick() = _scope.launch {

    }

    private fun topAppBarBackArrowOnClick() = _scope.launch {
        navigateBack()
    }


    sealed class UiEvent {
           data object NavigateBack: UiEvent()
           data class NavigateNext(val route: String, val params: Bundle): UiEvent()
    }
}