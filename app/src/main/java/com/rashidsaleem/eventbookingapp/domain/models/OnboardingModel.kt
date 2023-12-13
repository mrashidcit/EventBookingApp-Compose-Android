package com.rashidsaleem.eventbookingapp.domain.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rashidsaleem.eventbookingapp.R

data class OnboardingModel(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId: Int,
    @StringRes  val descriptionResId: Int,
) {
    companion object {
         fun defaultItems(): ArrayList<OnboardingModel> {
            return arrayListOf(
                OnboardingModel(
                    imageResId = R.drawable.img_onboarding_1,
                    titleResId = R.string.explore_upcoming_and_nearby_events,
                    descriptionResId = R.string.in_publishing_and_graphic_design_lorem
                ),
                OnboardingModel(
                    imageResId = R.drawable.img_onboarding_2,
                    titleResId = R.string.web_have_modern_events_calendar_feature,
                    descriptionResId = R.string.in_publishing_and_graphic_design_lorem
                ),
                OnboardingModel(
                    imageResId = R.drawable.img_onboarding_3,
                    titleResId = R.string.too_look_up_more_events_or_activities_nearby_by_map,
                    descriptionResId = R.string.in_publishing_and_graphic_design_lorem
                ),

                )
        }

    }
}


