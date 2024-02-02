package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter

import com.rashidsaleem.eventbookingapp.common.DateUtil
import java.util.Date

data class FilterUiState(
    val selectedDateType: SelectedDateType = SelectedDateType.Tomorrow,
    val startDate: Date? = null,  // In case of Today & Tomorrow startDate value will be used
    val endDate: Date? = null,
    val showDateRangeSelectionDialog: Boolean = false,
) {

    fun dateRangeLabelForDisplay(): String {
        val startDateStr = DateUtil.toString(startDate, DateUtil.MMMDashyyyy) ?: "..."
        val endDateStr = DateUtil.toString(endDate, DateUtil.MMMDashyyyy) ?: "..."
        return "$startDateStr to $endDateStr"
    }

    fun isEndDateSelected() = (endDate != null)

}


enum class SelectedDateType {
    Today,
    Tomorrow,
    ThisWeek,
    RangeFromCalendar
}