package com.rashidsaleem.eventbookingapp.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.enums.ProfileTypeEnum
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.domain.models.home.dummyInterests
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileEvent
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileUiState
import com.rashidsaleem.eventbookingapp.presentation.profile.TabItemEnum
import com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer.BottomContainer
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun ProfileContent(
    uiState: ProfileUiState,
    onEvent: (ProfileEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        TopAppBar(
            leadingIconId = R.drawable.ic_arrow_left,
            contentColor = Color.Black,
            text = stringResource(id = R.string.profile),
            leadingIconOnClick = {
                onEvent(ProfileEvent.NavigateBack)
            },
        )
        Spacer(modifier = Modifier.height(29.dp))
        TopContainer(
            modifier = Modifier.padding(horizontal = 20.dp),
            uiState = uiState,
            onEvent = onEvent,
        )
        BottomContainer(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
            ,
            uiState = uiState,
            onEvent = onEvent
        )
    }

}



@Preview
@Composable
fun ProfileContentPreview() {

    val uiState = ProfileUiState(
        user = UserModel(
            id = 1,
            firstName = "Ashfak",
            lastName = "Sayem",
            pic = "https://raw.githubusercontent.com/mrashidcit/EventBookingApp-Compose-Android/ui/app/src/main/res/drawable/img_going_3.png",
            following = 350,
            followers = 346,
            aboutMe = "Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase.",
            interests = dummyInterests()
        ),
        profileType = ProfileTypeEnum.My,
        selectedTab = TabItemEnum.EVENT,
        events = EventModel.dummyEvents()
    )

    EventBookingAppTheme {
        Surface {
            ProfileContent(
                uiState = uiState,
                onEvent = {}
            )
        }
    }
}