package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue5
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue6
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray17
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray18
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBoxContainer(
    modifier: Modifier = Modifier,
    searchQuery: String,
    placeholder: String = "Search...",
    onValueChange: (String) -> Unit,
    searchIconColor: Color = Color.White,
    verticalBarColor: Color = Blue4,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        containerColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        placeholderColor = Color.White.copy(0.30f),
    ),
    filterContainerColor: Color = Blue6,
    filterIconColor: Color = Blue5,
    filterTextColor: Color = Color.White,
    searchIconOnClick: () -> Unit,
    filterButtonOnClick: () -> Unit,
    ) {
    TextField(
        modifier = modifier,
        value = searchQuery,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = airbnbCerealFontFamily,
                fontSize = 12.03.sp,
                fontWeight = FontWeight.Normal,
            )
        },
        colors = colors,
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            searchIconOnClick()
                        },
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = searchIconColor
                )
                Spacer(Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(20.dp)
                        .background(color = verticalBarColor)
                )
            }
        },
        trailingIcon = {
            SearchFilterButton(
                containerColor = filterContainerColor,
                iconColor = filterIconColor,
                textColor = filterTextColor,
            ) {
                filterButtonOnClick()
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchBoxContainerPreview() {
    EventBookingAppTheme {
        Surface {
            SearchBoxContainer(
                modifier = Modifier.fillMaxWidth(),
                searchQuery = "abc123",
                searchIconColor = Blue,
                verticalBarColor = Blue4,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    placeholderColor = Gray17
                ),
                filterContainerColor = Blue,
                filterIconColor = Color.White,
                filterTextColor = Gray18,
                onValueChange = {},
                searchIconOnClick = { /*TODO*/ }) {

            }
        }
    }
}