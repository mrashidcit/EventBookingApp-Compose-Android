package com.rashidsaleem.eventbookingapp.presentation.events.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.EventItem
import com.rashidsaleem.eventbookingapp.presentation.common.components.SearchBoxContainer
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray12
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray13
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray17
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray18

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsContent() {

    val horizontalPadding = remember {
        24.dp
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray13)
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        TopAppBar(
            contentColor = Black2,
            leadingIconOnClick = {  },
            text = stringResource(id = R.string.events),
            trailingIcons = {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = Black2
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.ic_more_vertical),
                    contentDescription = null,
                    tint = Black2
                )
            },
        )
        Spacer(modifier = Modifier.height(24.dp))
        SearchBoxContainer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            searchQuery = "",
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
            onValueChange = { },
            searchIconOnClick = {  },
            filterButtonOnClick = { },
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontalPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            items(12) {
                EventItem(
                    modifier = Modifier.fillMaxWidth(),
                    bookMarkOnClick = {  }) {
                    
                }
            }
        }

    }
}

@Preview
@Composable
fun EventsContentPreview() {
    EventBookingAppTheme {
        Surface {
            EventsContent()
        }
    }
}

