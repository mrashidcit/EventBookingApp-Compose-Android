package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppButton
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.enums.getDefaultHorizontalItemModelList
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray20
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray24

@Composable
fun FilterContent() {

    val horizontalItems = remember {
        getDefaultHorizontalItemModelList().apply {
            this[0] = this[0].copy(
                isSelected = true
            )
            this[2] = this[2].copy(
                isSelected = true
            )

        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 38.dp,
                    topEnd = 38.dp,
                ),
            )
            .padding(horizontal = 20.dp)
            .padding(top = 12.dp, bottom = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(26.dp)
                .height(5.dp)
                .background(
                    color = Gray24.copy(0.50f)
                )
                .clip(RoundedCornerShape(2.5.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppText(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.filter),
            fontSize = 25.sp,
            color = Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalList(items = horizontalItems)
        Spacer(modifier = Modifier.height(26.97.dp))
        TimeAndDateContainer()
        Spacer(modifier = Modifier.height(26.dp))
        LocationContainer()
        Spacer(modifier = Modifier.height(24.dp))
        SelectPriceRangeContainer()
        Spacer(modifier = Modifier.height(44.dp))
        // Bottom Buttons
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AppButton(
                modifier = Modifier.weight(0.7f),
                text = stringResource(id = R.string.reset).uppercase(),
                textFontSize = 16.sp,
                textFontWeight = FontWeight.Medium,
                contentPadding = PaddingValues(
                    top = 19.dp,
                    bottom = 18.dp,
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Gray20,
                ),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Black2,
                ),
            ) {

            }
            Spacer(modifier = Modifier.width(19.dp))
            AppButton(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.apply).uppercase(),
                textColor = Color.White,
                textFontSize = 16.sp,
                textFontWeight = FontWeight.Medium,
                contentPadding = PaddingValues(
                    top = 19.dp,
                    bottom = 18.dp,
                ),
//                border = BorderStroke(
//                    width = 1.dp,
//                    color = Gray20,
//                ),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Blue,
                )
            ) {

            }
        }
    }
}

@Preview
@Composable
fun FilterContentPreview() {
    EventBookingAppTheme {
        Surface {
            FilterContent()
        }
    }
}

