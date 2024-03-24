package com.rashidsaleem.eventbookingapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.Routes
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnboardingEnum.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class OnboardingViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.NextOnClick -> nextOnClick()
        }
    }

    private fun nextOnClick() {
        val nextOnboardingEnum = when (_uiState.value.onboardingEnum) {
            Onboarding1 -> Onboarding2
            Onboarding2 -> Onboarding3
            Onboarding3 -> {
                viewModelScope.launch(Dispatchers.Main) {
                    _eventFlow.emit(UiEvent.NavigateNext(Routes.signIn))
                }
                return
            }
        }

        val imageResId = when (nextOnboardingEnum) {
            Onboarding1 -> R.drawable.img_onboarding1
            Onboarding2 -> R.drawable.img_onboarding2
            Onboarding3 -> R.drawable.img_onboarding3
        }
        val titleResId = when (nextOnboardingEnum) {
            Onboarding1 -> R.string.explore_upcoming_and_nearby_events
            Onboarding2 -> R.string.web_have_modern_events_calendar_feature
            Onboarding3 -> R.string.to_look_up_more_events_or_activities_nearby_by_map
        }
        val descriptionResId = when (nextOnboardingEnum) {
            Onboarding1 -> R.string.inpublishing_and_graphic_design
            Onboarding2 -> R.string.inpublishing_and_graphic_design
            Onboarding3 -> R.string.inpublishing_and_graphic_design
        }

        _uiState.value = _uiState.value.copy(
            imageResId = imageResId,
            titleResId = titleResId,
            descriptionResId = descriptionResId,
            onboardingEnum = nextOnboardingEnum,
        )
    }

    sealed class UiEvent {
        data class NavigateNext(val route: String): UiEvent()
    }

}