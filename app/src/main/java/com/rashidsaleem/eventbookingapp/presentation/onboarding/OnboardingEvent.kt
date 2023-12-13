package com.rashidsaleem.eventbookingapp.presentation.onboarding

sealed class OnboardingEvent {
    object Skip: OnboardingEvent()
    object Next: OnboardingEvent()
}