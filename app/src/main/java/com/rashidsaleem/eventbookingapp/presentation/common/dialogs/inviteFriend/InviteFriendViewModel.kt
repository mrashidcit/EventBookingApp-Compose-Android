package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.AppUtil
import com.rashidsaleem.eventbookingapp.domain.models.InviteFriendModel
import com.rashidsaleem.eventbookingapp.domain.models.previewInviteFriends
import com.rashidsaleem.eventbookingapp.presentation.common.viewmodels.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.notify
import javax.inject.Inject

@HiltViewModel
class InviteFriendViewModel @Inject constructor() : BaseViewModel() {

    private val TAG = "InviteFriendViewModel"

    private val _scope = viewModelScope
    private val lock = Any()
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow =_eventFlow.asSharedFlow()
    private val _uiState = MutableStateFlow(InviteFriendUiState())
    val uiState = _uiState.asStateFlow()

    var tempSelectedItem: InviteFriendModel? = null

    private val _allItems = previewInviteFriends
    private val _items = MutableStateFlow(
        mutableStateListOf<InviteFriendModel>().apply {
            addAll(_allItems)
        }
    )
    val items = _items.asStateFlow()
//    val items = _uiState.combine(_items) { uiState, items ->
//        Log.d(TAG, "_uiState.combine: ")
//        tempSelectedItem?.id?.let { itemId ->
//            val item = items.firstOrNull { it.id == itemId }
//            Log.d(TAG, "_uiState.combine: $item")
//        }
//        items
//        if (uiState.searchQuery.isEmpty()) {
//            items
//        } else {
//            items.filter {
//                it.doesMatchSearchQuery(uiState.searchQuery)
//            }
//        }
//    }
//        .stateIn(
//            scope = _scope,
//            started = SharingStarted.WhileSubscribed(5000),
//            initialValue = _items.value.toList()
//        )


    fun onEvent(event: InviteFriendEvent) {
        when (event) {
            InviteFriendEvent.Invite -> inviteOnClick()
            is InviteFriendEvent.ItemOnClick -> itemOnClick(event.item)
            is InviteFriendEvent.UpdateSearchQuery -> updateSearchQuery(event.value)
        }
    }

    private fun updateSearchQuery(value: String) {
        _uiState.update {
            it.copy(
                searchQuery = value
            )
        }

        _items.value.clear()
        _items.value.addAll(
            if (value.isEmpty()) {
                _allItems
            } else {
                _allItems.filter { it.doesMatchSearchQuery(value) }
            }
        )
    }

    private fun itemOnClick(item: InviteFriendModel) = _scope.launch {
        tempSelectedItem = item
        val itemIndex = _items.value.indexOfFirst { it.id == item.id }
        Log.d(
            TAG,
            "itemOnClick: itemIndex = $itemIndex ... item.id = ${item.id} ... item.isSelected = ${item.isSelected}"
        )
        if (itemIndex == -1) return@launch

        _items.value[itemIndex] = _items.value[itemIndex].let {
            it.copy(
                isSelected = !it.isSelected
            )
        }

        Log.d(
            TAG,
            "after itemOnClick: itemIndex = $itemIndex ... item.isSelected = ${_items.value[itemIndex]}"
        )
    }

    private fun inviteOnClick() = _scope.launch {

        AppUtil.showToast(AppUtil.getStringResource(R.string.invitation_sent))

        launch(Dispatchers.Main) {
            _eventFlow.emit(UiEvent.CloseDialog)
        }
    }

    sealed class UiEvent {
        object CloseDialog: UiEvent()
    }

}