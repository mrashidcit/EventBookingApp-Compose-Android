package com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileEvent
import com.rashidsaleem.eventbookingapp.presentation.profile.TabItemEnum
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1

@Composable
fun TabContainer(
    modifier: Modifier = Modifier,
    tabItemEnum: TabItemEnum,
    onEvent: (ProfileEvent) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TabItem(
            title = stringResource(id = R.string.about).uppercase(),
            isSelected = tabItemEnum == TabItemEnum.ABOUT,
            onClick = {
                onEvent(ProfileEvent.TabItemOnClick(TabItemEnum.ABOUT))
            }
        )
        TabItem(
            title = stringResource(id = R.string.event).uppercase(),
            isSelected = tabItemEnum == TabItemEnum.EVENT,
            onClick = {
                onEvent(ProfileEvent.TabItemOnClick(TabItemEnum.EVENT))
            }
        )
        TabItem(
            title = stringResource(id = R.string.reviews).uppercase(),
            isSelected = tabItemEnum == TabItemEnum.REVIEWS,
            onClick = {
                onEvent(ProfileEvent.TabItemOnClick(TabItemEnum.REVIEWS))
            }
        )

    }
}

@Composable
fun TabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppText(
            text = title,
            color = if (isSelected) Blue else Gray1,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            thickness = 3.dp,
            color = if (isSelected) Blue else Color.Transparent,
        )
    }
}