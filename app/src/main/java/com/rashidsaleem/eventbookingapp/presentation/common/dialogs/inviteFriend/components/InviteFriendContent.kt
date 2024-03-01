package com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.InviteFriendModel
import com.rashidsaleem.eventbookingapp.domain.models.previewInviteFriends
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.InviteFriendEvent
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.inviteFriend.InviteFriendUiState
import com.rashidsaleem.eventbookingapp.presentation.events.EventsUiComponent
import com.rashidsaleem.eventbookingapp.presentation.events.EventsUiEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray11
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray24
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray32
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray33
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun InviteFriendContent(
    uiState: InviteFriendUiState,
    items: List<InviteFriendModel>,
    onEvent: (InviteFriendEvent) -> Unit,
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(horizontal = 24.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 38.dp,
                    topEnd = 38.dp,
                ),
            ),
    ) {

        val (topContainer, listContainer, inviteButton) = createRefs()

        TopContainer(
            modifier = Modifier.constrainAs(topContainer) {
                top.linkTo(parent.top)
            },
            uiState = uiState,
            onEvent = onEvent,
        )
        
        ListComponent(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(listContainer) {
                    top.linkTo(topContainer.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                },
            contentPadding = PaddingValues(
                vertical = 20.dp,
            ),
            items = items,
            onEvent = onEvent,
        )

        InviteButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 27.dp)
                .constrainAs(inviteButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = {
                onEvent(InviteFriendEvent.Invite)
            }
        )

    }
}

@Composable
private fun InviteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue
        ),
        shape = RoundedCornerShape(14.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Row(
            modifier = Modifier.padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.invite).uppercase(),
                fontFamily = airbnbCerealFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Box(
                modifier = Modifier
                    .background(color = Blue1, shape = CircleShape)
                    .size(30.dp)
            ) {
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    }
}

@Composable
private fun TopContainer(
    modifier: Modifier = Modifier,
    uiState: InviteFriendUiState,
    onEvent: (InviteFriendEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))
//        Box(
//            modifier = Modifier
//                .width(26.dp)
//                .height(5.dp)
//                .background(
//                    color = Gray24.copy(0.50f),
//                    shape = RoundedCornerShape(2.5.dp)
//                )
//        )
//        Spacer(modifier = Modifier.height(17.dp))
        AppText(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.invite_friend),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Black2,
        )
        Spacer(modifier = Modifier.height(7.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = uiState.searchQuery,
            onValueChange = {
                onEvent(InviteFriendEvent.UpdateSearchQuery(it))
            },
            placeholder = {
                AppText(
                    modifier = Modifier.padding(start = 10.dp),
                    text = stringResource(id = R.string.search),
                    fontSize = 14.sp,
                    lineHeight = 23.sp,
                    color = Gray32,
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(16.dp),
                    tint = Blue
                )
            },
            shape = RoundedCornerShape(100.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Gray33,
            )

        )

    }
}

@Preview
@Composable
fun InviteFriendContentPreview() {
    EventBookingAppTheme {
        Surface {

            val uiState = remember {
                InviteFriendUiState()
            }
            val items = remember {
                previewInviteFriends
            }

            InviteFriendContent(
                uiState = uiState,
                items = items,
            ) {

            }
        }
    }
}

