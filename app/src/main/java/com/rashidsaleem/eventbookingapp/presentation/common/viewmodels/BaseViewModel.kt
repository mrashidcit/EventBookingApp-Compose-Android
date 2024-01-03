package com.rashidsaleem.eventbookingapp.presentation.common.viewmodels

import androidx.lifecycle.ViewModel
import com.rashidsaleem.eventbookingapp.presentation.common.BaseEvent
import com.rashidsaleem.eventbookingapp.presentation.common.BaseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel: ViewModel() {

    private val _baseUiState: MutableStateFlow<BaseUiState> = MutableStateFlow(BaseUiState())
    val baseUiState: StateFlow<BaseUiState> = _baseUiState.asStateFlow()

    fun baseOnEvent(event: BaseEvent) {
        when (event) {
            is BaseEvent.ShowLoader -> showLoader(event.value)
        }
    }

    fun showLoader(value: Boolean) {
        _baseUiState.update {
            it.copy(
                showLoader = value
            )
        }
    }


}