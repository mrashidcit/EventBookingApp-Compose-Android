package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.rashidsaleem.eventbookingapp.common.DateUtil
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.SelectedDateType.*
import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemModel
import com.rashidsaleem.eventbookingapp.presentation.common.enums.getDefaultHorizontalItemModelList
import com.rashidsaleem.eventbookingapp.presentation.common.util.Logger
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor() : BaseViewModel() {

    private val TAG = "FilterViewModel"

    private val _horizontalItems: SnapshotStateList<HorizontalItemModel> =
        mutableStateListOf<HorizontalItemModel>().apply {
            addAll(getDefaultHorizontalItemModelList())
        }
    val horizontalItems: List<HorizontalItemModel> = _horizontalItems

    private val _uiState: MutableStateFlow<FilterUiState> = MutableStateFlow(FilterUiState())
    val uiState: StateFlow<FilterUiState> = _uiState.asStateFlow()

    init {
        val selectedDateType = _uiState.value.selectedDateType
        if (selectedDateType == Tomorrow) {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, 1)
            updateUiState(
                startDate = calendar.time
            )
        }
    }

    private fun updateUiState(
        selectedDateType: SelectedDateType? = null,
        startDate: Date? = null,
        endDate: Date? = null,
    ) {
        _uiState.update {
            it.copy(
                selectedDateType = selectedDateType ?: it.selectedDateType,
                startDate = startDate ?: it.startDate,
                endDate = endDate ?: it.endDate,
            )
        }
    }

    fun onEvent(event: FilterDialogEvent) {
        when (event) {
            FilterDialogEvent.Apply -> {}
            FilterDialogEvent.Reset -> {}
            is FilterDialogEvent.UpdateHorizontalItemIsSelected -> updateHorizontalItemIsSelected(event.value, event.item)
            is FilterDialogEvent.UpdateSelectedDateType -> updateSelectedDateType(event.value)
            is FilterDialogEvent.ShowDateRangeSelectionDialog -> showDateRangeSelectionDialog(event.value)
            is FilterDialogEvent.UpdateDateRange -> updateDateRange(event.startDate, event.endDate)
        }
    }

    private fun updateDateRange(startDate: Date?, endDate: Date?) {
        _uiState.update {
            it.copy(
                startDate = startDate,
                endDate = endDate,
            )
        }
    }

    private fun showDateRangeSelectionDialog(value: Boolean) {
        _uiState.update {
            it.copy(
                showDateRangeSelectionDialog = value
            )
        }
    }

    private fun updateSelectedDateType(value: SelectedDateType) {
        Logger.d(TAG, "updateSelectedDateType: valur = ${value.name}")
        val calendar: Calendar = Calendar.getInstance()
        var startDate: Date? = null
        var endDate: Date? = null
        when (value) {
            Today -> {
                startDate = calendar.time
            }
            Tomorrow -> {
                startDate = calendar.let {
                    it.add(Calendar.DATE, 1)
                    it.time
                }
            }
            ThisWeek -> {
                val dateList = DateUtil.getWeek1stDayAndLastDayDate(calendar.time)
                if (dateList.isNotEmpty()) {
                    startDate = dateList[0]
                    endDate = dateList[1]
                }
            }
            else -> { }
        }
        updateUiState(
            selectedDateType = value,
            startDate = startDate,
            endDate = endDate
        )
    }

    private fun updateHorizontalItemIsSelected(value: Boolean, item: HorizontalItemModel) {
        val itemIndex = _horizontalItems.indexOf(item)
        if (itemIndex == -1) return
        Log.d(TAG, "updateHorizontalItemIsSelected: before = ${_horizontalItems[itemIndex]}")

        _horizontalItems[itemIndex] = item.copy(
            isSelected = value
        )
        Log.d(TAG, "updateHorizontalItemIsSelected: after = ${_horizontalItems[itemIndex]}")
    }















}












