package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.AppUtil
import com.rashidsaleem.eventbookingapp.domain.models.InviteFriendModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1

@Composable
fun ListItem(
    item: InviteFriendModel,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.profilePic)
                .crossfade(true)
                .build(),
//            placeholder = painterResource(R.drawable.ic_person),
            placeholder = painterResource(R.drawable.img_user_ashfak),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(11.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            AppText(
                text = "${item.firstName} ${item.lastName}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Black2
            )
            Spacer(modifier = Modifier.height(4.dp))
            AppText(
                text = "${AppUtil.followersForDisplay(item.followers)} Followers",
                fontSize = 13.sp,
                color = Gray1
            )
        }
        Image(
            painter = painterResource(
                id = if (item.isSelected)
                    R.drawable.ic_check_circle_on
                else
                    R.drawable.ic_check_circle_off
            ),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun ListItemPreview() {
    EventBookingAppTheme {
        Surface {
            val item = remember {
                InviteFriendModel(
                    id = 1,
                    firstName = "Aex",
                    lastName = "Lee",
                    profilePic = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    followers = 2000,
                    isSelected = true,
                )
            }
            ListItem(
                item = item
            ) {

            }
        }
    }
}

