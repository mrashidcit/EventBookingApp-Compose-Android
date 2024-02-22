package com.rashidsaleem.eventbookingapp.presentation.notifications.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.DateUtil
import com.rashidsaleem.eventbookingapp.domain.models.NotificationModel
import com.rashidsaleem.eventbookingapp.domain.models.NotificationTypeEnum
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppButton
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray29
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray30
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray9

@Composable
fun NotificationItem(
    notification: NotificationModel,
    acceptOnClick: () -> Unit,
    rejectOnClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(notification.userProfilePictureUrl)
                    .crossfade(true)
                    .build(),
//                placeholder = painterResource(R.drawable.ic_person),
                placeholder = painterResource(R.drawable.img_user_ashfak),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(14.dp))
            AppText(
                modifier = Modifier.weight(1f),
                text = AnnotatedString(
                    text = notification.userFullName,
                    spanStyle = SpanStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                ).plus(
                    AnnotatedString(
                        text = " " + when (notification.type) {
                            NotificationTypeEnum.StartedFollowingYou -> "Started \nfollowing you"
                            NotificationTypeEnum.Invite -> "Invite you \n${notification.eventName}"
                            NotificationTypeEnum.LikeYourEvents -> "Like you \nevents"
                            NotificationTypeEnum.JoinYourEvent -> "Join your \nEvent ${notification.eventName}"
                        },
                        spanStyle = SpanStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                        )
                    )
                ),
                color = Gray29,
            )
            AppText(
                text = DateUtil.toStringForNotification(notification.date),
                fontSize = 12.sp,
                color = Gray29,
            )
        }
        if (notification.type == NotificationTypeEnum.Invite) {
            ButtonsContainer(
                acceptOnClick = acceptOnClick,
                rejectOnClick = rejectOnClick
            )
        }

    }

}

@Composable
private fun ButtonsContainer(
    acceptOnClick: () -> Unit,
    rejectOnClick: () -> Unit,
) {
    Row {
        AppButton(
            text = stringResource(id = R.string.reject),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Gray30,
                backgroundColor = Color.Transparent
            ),
            shape = RoundedCornerShape(6.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            ),
            border = BorderStroke(1.dp, Gray9),
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 20.dp,
            )

        ) {
            rejectOnClick()
        }
        Spacer(modifier = Modifier.width(13.dp))
        AppButton(
            text = stringResource(id = R.string.accept),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Blue
            ),
            textColor = Color.White,
            shape = RoundedCornerShape(6.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            ),
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 20.dp,
            )
        ) {
            acceptOnClick()
        }
    }
}

@Preview
@Composable
fun NotificationItemPreview() {
    EventBookingAppTheme {
        Surface {
            val notification = remember {
                NotificationModel(
                    id = 1,
                    userId = 1,
                    userFullName = "David Silbia",
                    userProfilePictureUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    type = NotificationTypeEnum.LikeYourEvents,
                    eventName = "Jo Malone London's Mother's",
                    date = System.currentTimeMillis()
                )
            }
            NotificationItem(
                notification = notification,
                acceptOnClick = {},
                rejectOnClick = {}
            )
        }
    }
}

