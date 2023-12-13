package com.rashidsaleem.eventbookingapp.presentation.onboarding

import com.rashidsaleem.eventbookingapp.domain.models.OnboardingModel

data class OnboardingUiState(
    val items: ArrayList<OnboardingModel> = OnboardingModel.defaultItems(),
    val currentIndex: Int = 0,
) {
    fun getCurrentItem() = items[currentIndex]
    fun shouldEnableSkipButton() = (currentIndex > 0)
}
