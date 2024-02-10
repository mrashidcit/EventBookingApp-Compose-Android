package com.rashidsaleem.eventbookingapp.presentation.profile.components.bottomContainer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.domain.models.home.InterestModel
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileEvent
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray26
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray27

@Composable
fun AboutContainer(
    uiState: ProfileUiState,
    onEvent: (ProfileEvent) -> Unit
) {
    AppText(
        text = uiState.user?.aboutMe,
        fontSize = 16.sp,
        lineHeight = 25.sp,
        color = Gray26,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
    Row(
        modifier = Modifier.clickable {
            onEvent(ProfileEvent.ReadMore)
        }, verticalAlignment = Alignment.Bottom
    ) {
        AppText(
            textResId = R.string.read_more,
            fontSize = 16.sp,
            lineHeight = 25.sp,
            color = Blue,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            modifier = Modifier
                .padding(start = 3.dp, bottom = 2.dp)
                .size(12.dp),
            painter = painterResource(R.drawable.ic_arrow_down),
            contentDescription = stringResource(id = R.string.read_more),
            tint = Blue,
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    // Interest
    InterestsContainer(uiState)
}

@Composable
private fun InterestsContainer(uiState: ProfileUiState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppText(
            textResId = R.string.interest,
            fontSize = 18.sp,
            lineHeight = 34.sp,
            fontWeight = FontWeight.Medium,
            color = Gray27,
        )

        Row(
            modifier = Modifier
                .background(
                    color = Blue.copy(0.10f), shape = RoundedCornerShape(14.dp)
                )
                .clickable { }
                .padding(
                    horizontal = 14.dp
                )
                .padding(
                    top = 8.dp, bottom = 7.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(13.dp),
                painter = painterResource(id = R.drawable.ic_edit_profile),
                contentDescription = stringResource(id = R.string.change_interest),
                tint = Blue,
            )
            Spacer(modifier = Modifier.width(6.dp))
            AppText(
                text = stringResource(R.string.change).uppercase(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = Blue,
            )
        }

    }
    Spacer(modifier = Modifier.height(15.dp))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(uiState.user.interests.subList(0, 4)) { interest ->
            InterestItem(interest)
            Spacer(modifier = Modifier.width(7.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(uiState.user.interests.subList(4, uiState.user.interests.size)) { interest ->
            InterestItem(interest)
            Spacer(modifier = Modifier.width(7.dp))
        }
    }
}

@Composable
private fun InterestItem(
    interest: InterestModel,
) {
    Box(
        modifier = Modifier
            .background(
                color = interest.color,
                shape = RoundedCornerShape(16.dp),
            )
            .padding(vertical = 7.dp, horizontal = 15.dp)
    ) {
        AppText(
            text = interest.label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
        )
    }
}