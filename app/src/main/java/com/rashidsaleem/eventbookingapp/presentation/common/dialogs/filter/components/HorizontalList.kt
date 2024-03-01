package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.FilterDialogEvent
import com.rashidsaleem.eventbookingapp.presentation.common.enums.HorizontalItemModel
import com.rashidsaleem.eventbookingapp.presentation.common.enums.getDefaultHorizontalItemModelList
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray20
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray21

@Composable
fun HorizontalList(
    items: List<HorizontalItemModel>,
    onEvent: (FilterDialogEvent) -> Unit,
) {
    LazyRow(
        content = {
            items(items.size) { index ->
                val item = items[index]
                ItemComponent(
                    item = item,
                    onClick = {
                        val isSelectedTargetValue = !item.isSelected
                        onEvent(
                            FilterDialogEvent.UpdateHorizontalItemIsSelected(
                                value = isSelectedTargetValue,
                                item = item
                            ),
                        )
                    }
                )
            }
        },
    )
}

@Composable
private fun ItemComponent(
    item: HorizontalItemModel,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(top = 12.dp)
                .then(
                    if (item.isSelected)
                        Modifier.shadow(
                            elevation = 12.dp,
                            shape = CircleShape,
                            ambientColor = Blue
                        )
                    else
                        Modifier
                )
                .size(63.29.dp)
                .clip(CircleShape)
                .background(
                    color = if (item.isSelected) Blue else Color.White
                )
                .then(
                    if (item.isSelected)
                        Modifier
                    else
                        Modifier
                            .border(
                                width = 1.dp,
                                color = Gray20,
                                shape = CircleShape,
                            )
                )
        ) {
            Icon(
                modifier = Modifier
                    .size(29.53.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                tint = if (item.isSelected) Color.White else Gray21,
            )
        }
        Spacer(modifier = Modifier.height(10.74.dp))
        AppText(
            textResId = item.titleId,
            fontSize = 14.sp,
            lineHeight = 23.sp,
            color = Black2
        )
    }
}

@Preview
@Composable
fun HorizontalListPreview() {
    EventBookingAppTheme {
        Surface {

            val items = remember {
                getDefaultHorizontalItemModelList().apply {
                    this[0] = this[0].copy(
                        isSelected = true
                    )
                    this[2] = this[2].copy(
                        isSelected = true
                    )

                }

            }

            HorizontalList(
                items = items,
                onEvent = { }
            )
        }
    }
}

