package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter

import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemModel

sealed class FilterDialogEvent {
    data object Reset: FilterDialogEvent()
    data object Apply: FilterDialogEvent()
    data class UpdateHorizontalItemIsSelected(val value: Boolean, val item: HorizontalItemModel): FilterDialogEvent()
    data class UpdateSelectedDateType(val value: SelectedDateType): FilterDialogEvent()
}