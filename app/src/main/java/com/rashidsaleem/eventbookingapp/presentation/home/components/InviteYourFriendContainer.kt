package com.rashidsaleem.eventbookingapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeContentEvent
import com.rashidsaleem.eventbookingapp.presentation.home.states.HomeContentUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Aqua
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun InviteYourFriendContainer(
    modifier: Modifier = Modifier,
    homeContentOnEvent: (HomeContentEvent) -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(127.dp)
            .background(color = Aqua.copy(0.16f), shape = RoundedCornerShape(12.dp))
    ) {

        val (textInfo, image) = createRefs()

        Column(
            modifier = Modifier
                .constrainAs(textInfo) {
                    start.linkTo(parent.start, 18.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.Center
        ) {
            AppText(
                text = stringResource(id = R.string.inviteYourFriends),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Black2,
            )
            Spacer(Modifier.height(10.dp))
            AppText(
                text = stringResource(id = R.string.get20DollarForTicket),
                fontSize = 13.sp,
                color = Black4,
            )
            Spacer(Modifier.height(13.dp))
            Box(
                modifier = Modifier
                    .background(color = Aqua, shape = RoundedCornerShape(5.dp))
                    .clickable { homeContentOnEvent(HomeContentEvent.InviteYourFriend) }
                    .padding(vertical = 5.dp, horizontal = 14.dp)
            ) {
                AppText(
                    text = stringResource(id = R.string.invite).uppercase(),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }

        Image(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.percent(0.5f)
                },
            painter = painterResource(id = R.drawable.img_invite_gift),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }
}

@Preview
@Composable
fun InviteYourFriendContainerPreview() {
    EventBookingAppTheme {
        Surface {
            InviteYourFriendContainer(
                homeContentOnEvent = {}
            )
        }
    }
}

