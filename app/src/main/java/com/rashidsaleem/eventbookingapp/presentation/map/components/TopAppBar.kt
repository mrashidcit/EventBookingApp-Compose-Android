package com.rashidsaleem.eventbookingapp.presentation.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black7
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray8
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray9
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.SunsetOrange

@Composable
fun TopAppBar(
    searchQuery: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(SunsetOrange)
            .padding(horizontal = 25.dp)
            .padding(top = 25.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = searchQuery,
            onValueChange = { },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                unfocusedBorderColor = Gray9,
                focusedBorderColor = Blue,
                leadingIconColor = Black7,
            ),
            placeholder = {
                AppText(
                    modifier = Modifier,
                    text = stringResource(id = R.string.find_for_food_or_restaurant_nearby_you),
                    fontSize = 14.sp,
                    color = Gray8.copy(0.50f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier
//                        .width(6.32.dp)
//                        .height(12.dp)
                        .clickable {

                    },
                    painter = painterResource(id = R.drawable.ic_arrow_back_ios),
                    contentDescription = null,
                )
            }
        )
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp),
                )
                .padding(
                    start = 14.dp,
                    top = 15.dp,
                    end = 15.dp,
                    bottom = 14.dp,
                )
                .clickable { }
        ) {
            Image(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = R.drawable.ic_gps_location_icon),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    EventBookingAppTheme {
        Surface(
//            modifier = Modifier.fillMaxSize(),
            color = Color.Green,
        ) {
            TopAppBar(
                searchQuery = "",
            )
        }
    }
}

