package com.rashidsaleem.eventbookingapp.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rashidsaleem.eventbookingapp.R

data class OnboardingUiState(
    @DrawableRes val imageResId: Int = R.drawable.img_onboarding1,
    @StringRes val titleResId: Int = R.string.explore_upcoming_and_nearby_events,
    @StringRes val descriptionResId: Int = R.string.inpublishing_and_graphic_design,
    val onboardingEnum: OnboardingEnum = OnboardingEnum.Onboarding1,
)

enum class OnboardingEnum {
    Onboarding1,
    Onboarding2,
    Onboarding3,
}


val previewOnboardingUiState = OnboardingUiState(
    onboardingEnum = OnboardingEnum.Onboarding1
)