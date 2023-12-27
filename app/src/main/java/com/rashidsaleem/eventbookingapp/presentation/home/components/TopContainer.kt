package com.rashidsaleem.eventbookingapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue3
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue5
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray5
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopContainer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Blue3)
    ) {
        // AppBar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .height(29.2.dp),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                tint = Color.White,
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.currentLocation),
                        color = Color.White.copy(0.70f),
                        fontFamily = airbnbCerealFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                    )
                    Spacer(Modifier.width(3.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "New York, USA",
                    color = Gray5,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                )
            }

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(color = Color.White.copy(0.10f), shape = CircleShape)
            ) {
                Icon(
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        // SearchBox
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Search...",
                    fontFamily = airbnbCerealFontFamily,
                    fontSize = 12.03.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White.copy(0.30f),
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                containerColor = Color.Transparent,
            ),
            leadingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(20.dp)
                            .background(color = Blue4)
                    )
                }
            },
            trailingIcon = {
                Row(
                    modifier = Modifier
                        .background(color = Blue5, shape = RoundedCornerShape(50.dp))
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        modifier = Modifier.size(23.75.dp),
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = null,
                    )
                    Spacer(Modifier.width(3.7.dp))
                    Text(
                        text = stringResource(id = R.string.filters),
                        fontFamily = airbnbCerealFontFamily,
                        fontSize = 20.33.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                    )
                }
            }
        )

    }
}

@Preview
@Composable
fun TopContainerPreview() {
    EventBookingAppTheme {
        Surface(color = Color.White) {
            TopContainer()
        }
    }
}



