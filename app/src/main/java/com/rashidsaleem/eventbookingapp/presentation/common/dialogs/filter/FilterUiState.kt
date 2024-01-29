package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter

import java.util.Date

data class FilterUiState(
    val selectedDateType: SelectedDateType = SelectedDateType.Tomorrow,
    val startDate: Date? = null,  // In case of Today & Tomorrow startDate value will be used
    val endDate: Date? = null,
)


enum class SelectedDateType {
    Today,
    Tomorrow,
    ThisWeek,
    RangeFromCalendar
}