package com.rashidsaleem.eventbookingapp.presentation.common.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rashidsaleem.eventbookingapp.R

enum class HorizontalItemEnum {
    Sports,
    Music,
    Food,
    Art
}

data class HorizontalItemModel(
        val enum: HorizontalItemEnum,
        @StringRes val titleId: Int,
        @DrawableRes val iconId: Int,
        val isSelected: Boolean = false,
    )

fun HorizontalItemEnum.getIconId(): Int {
    return when (this) {
        HorizontalItemEnum.Sports -> R.drawable.ic_sports
        HorizontalItemEnum.Music -> R.drawable.ic_music
        HorizontalItemEnum.Food -> R.drawable.ic_food
        HorizontalItemEnum.Art -> R.drawable.ic_art
    }
}

fun HorizontalItemEnum.getTitleId(): Int {
    return when (this) {
        HorizontalItemEnum.Sports -> R.string.sports
        HorizontalItemEnum.Music -> R.string.music
        HorizontalItemEnum.Food -> R.string.food
        HorizontalItemEnum.Art -> R.string.art
    }
}


fun getDefaultHorizontalItemModelList(): ArrayList<HorizontalItemModel> {
    return HorizontalItemEnum.values().map { enum ->
        HorizontalItemModel(
            enum = enum,
            titleId = enum.getTitleId(),
            iconId = enum.getIconId(),
        )
    } as ArrayList<HorizontalItemModel>

}

