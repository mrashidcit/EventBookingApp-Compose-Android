package com.rashidsaleem.eventbookingapp.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.home.UserModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.components.TopAppBar
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray12
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray25

@Composable
fun ProfileContent(
    uiState: ProfileUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray12),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            leadingIconId = R.drawable.ic_arrow_left,
            contentColor = Color.Black,
            text = stringResource(id = R.string.profile),
            leadingIconOnClick = {

            },
        )
        Spacer(modifier = Modifier.height(29.dp))
        TopContainer(uiState)


    }

}



@Preview
@Composable
fun ProfileContentPreview() {

    val uiState = ProfileUiState(
        user = UserModel(
            firstName = "Ashfak",
            lastName = "Sayem",
            pic = "https://raw.githubusercontent.com/mrashidcit/EventBookingApp-Compose-Android/ui/app/src/main/res/drawable/img_going_3.png",
            following = 350,
            followers = 346,
            aboutMe = "",
            interests = listOf()
        )
    )

    EventBookingAppTheme {
        Surface {
            ProfileContent(
                uiState = uiState,
            )
        }
    }
}