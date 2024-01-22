package com.rashidsaleem.eventbookingapp.presentation.map

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MapScreenViewModel : BaseViewModel() {

    private val TAG = "MapScreenViewModel"
    private val _scope = viewModelScope

    private val _uiState: MutableStateFlow<MapViewState> = MutableStateFlow(MapViewState())
    val uiState: StateFlow<MapViewState> = _uiState.asStateFlow()

    private val _eventFlow: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    init {
        _uiState.update {
            it.copy(
                events = EventModel.dummyEvents()
            )
        }

    }

    fun onEvent(event: MapViewEvent) {
        when (event) {
            is MapViewEvent.PerformSearch -> performSearch(event.value)
            is MapViewEvent.TopListItemOnClick -> topListItemOnClick(event.value)
            is MapViewEvent.EventListItemOnClick -> eventListItemOnClick(event.value)
            is MapViewEvent.EventBookMark -> toggleEventBookMark(event.value)
            MapViewEvent.BackArrowIconOnClick -> backArrowIconOnClick()
            MapViewEvent.MyLocationIconOnClick -> myLocationIconOnClick()
        }
    }

    private fun myLocationIconOnClick() {

    }

    private fun backArrowIconOnClick() = _scope.launch(Dispatchers.Main) {
        _eventFlow.emit(UiEvent.NavigateBack)
    }

    private fun toggleEventBookMark(eventModel: EventModel) {
        val newBookMarkedValue = eventModel.isBookmarked.not()

        val itemIndex = _uiState.value.events.indexOfFirst { it.id == eventModel.id }
        val updatedEvent = eventModel.copy(
            isBookmarked = newBookMarkedValue
        )
        try {
            _uiState.update {
                it.copy(
                    events = it.events.apply {
                        this[itemIndex] = updatedEvent
                    }
                )
            }
        } catch (ex: Exception) {
            Log.e(TAG, ex.message, ex)
        }

    }

    private fun eventListItemOnClick(event: EventModel) {

        val params = bundleOf().apply {
            val gson = Gson()
            val eventJson = try {
                gson.toJson(event, EventModel::class.java)
            } catch (ex: Exception) {
                ""
            }
            putString(AppConstants.KEY_EVENT_MODEL, eventJson)
        }

        _scope.launch(Dispatchers.Main) {
            _eventFlow.emit(
                UiEvent.NavigateNext(
                    route = Routes.eventDetail,
                    params = params
                )
            )
        }
    }

    private fun topListItemOnClick(value: HorizontalItemEnum) {
        Log.d(TAG, "topListItemOnClick: ${value.name}")

    }

    private fun performSearch(value: String) {
        _uiState.update {
            it.copy(
                searchQuery = value
            )
        }
    }

    sealed class UiEvent {
        data class NavigateNext(val route: String, val params: Bundle) : UiEvent()
        data object NavigateBack : UiEvent()
    }

}