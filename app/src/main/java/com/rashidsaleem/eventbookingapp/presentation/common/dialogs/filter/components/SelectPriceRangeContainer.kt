package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue7
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray23

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectPriceRangeContainer() {

    var sliderPosition by remember { mutableStateOf(20f..120f) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            AppText(
                textResId = R.string.select_price_range,
                fontSize = 16.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
            )
            AppText(
                text = "$${sliderPosition.start.toInt()}-$${sliderPosition.endInclusive.toInt()}",
                fontSize = 18.sp,
                lineHeight = 34.sp,
                color = Blue7,
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Column {
            RangeSlider(
                value = sliderPosition,
//                steps = 5,
                onValueChange = { range -> sliderPosition = range },
                valueRange = 5f..200f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = Blue,
                    inactiveTrackColor = Gray23,
                )
            )
        }
    }
}

@Preview
@Composable
fun SelectPriceRangeContainerPreview() {
    EventBookingAppTheme {
        Surface {
            SelectPriceRangeContainer()
        }
    }
}

