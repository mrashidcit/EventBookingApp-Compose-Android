package com.rashidsaleem.eventbookingapp.presentation.onboarding

sealed class OnboardingEvent {
    object NextOnClick: OnboardingEvent()
}