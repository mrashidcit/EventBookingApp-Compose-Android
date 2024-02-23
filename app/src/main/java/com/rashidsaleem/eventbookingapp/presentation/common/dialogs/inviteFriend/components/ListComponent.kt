package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.domain.models.InviteFriendModel
import com.rashidsaleem.eventbookingapp.domain.models.previewInviteFriends
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun ListComponent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    items: List<InviteFriendModel>,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) {item ->
            ListItem(
                item = item
            ) {

            }
        }
    }
}

@Preview
@Composable
fun ListComponentPreview() {
    EventBookingAppTheme {
        Surface {
            val items = remember {
                previewInviteFriends
            }
            ListComponent(
                modifier = Modifier.fillMaxSize(),
                items = items,
            )
        }
    }
}

