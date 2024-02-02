package com.rashidsaleem.eventbookingapp.presentation.profile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.ButtonColors
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
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppButton
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray25

@Composable
fun TopContainer(uiState: ProfileUiState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://example.com/image.jpg")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_person),
            contentDescription = uiState.user.firstName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))
        AppText(
            text = uiState.user.getFullName(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Black2,
        )
        Spacer(modifier = Modifier.height(9.dp))
        UserTextInfoContainer(uiState.user)
        Spacer(modifier = Modifier.height(22.dp))
        Button(
            shape = RoundedCornerShape(8.dp),
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.White,
            ),
            border = BorderStroke(
                width = 1.dp,
                color = Blue
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(id = R.drawable.ic_edit_profile),
                    contentDescription = stringResource(id = R.string.edit_profile),
                    tint = Blue,
                )
                Spacer(modifier = Modifier.width(16.dp))
                AppText(
                    textResId = R.string.edit_profile,
                    fontSize = 16.sp,
                    lineHeight = 25.sp,
                    color = Blue,
                )
            }
        }

    }
}

@Composable
private fun UserTextInfoContainer(user: UserModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppText(
                text = "${user.following}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
                lineHeight = 34.sp
            )
            AppText(
                text = stringResource(id = R.string.following),
                fontSize = 14.sp,
                lineHeight = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Gray1,
            )
        }
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(1.dp)
                .background(color = Gray25)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppText(
                text = "${user.following}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
                lineHeight = 34.sp
            )
            AppText(
                text = stringResource(id = R.string.following),
                fontSize = 14.sp,
                lineHeight = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Gray1,
            )
        }
    }
}

@Preview
@Composable
fun TopContainerPreview() {
    EventBookingAppTheme {
        Surface {
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

            TopContainer(uiState = uiState)
        }
    }
}














