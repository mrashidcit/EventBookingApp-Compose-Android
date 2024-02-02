package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter

import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemModel
import java.util.Date

sealed class FilterDialogEvent {
    data object Reset: FilterDialogEvent()
    data object Apply: FilterDialogEvent()
    data class UpdateHorizontalItemIsSelected(val value: Boolean, val item: HorizontalItemModel): FilterDialogEvent()
    data class UpdateSelectedDateType(val value: SelectedDateType): FilterDialogEvent()
    data class ShowDateRangeSelectionDialog(val value: Boolean): FilterDialogEvent()
    data class UpdateDateRange(val startDate: Date?, val endDate: Date?): FilterDialogEvent()

}