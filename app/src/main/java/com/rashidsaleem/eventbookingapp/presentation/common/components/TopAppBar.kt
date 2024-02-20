package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun TopAppBar(
    verticalPadding: Dp = 16.dp,
    horizontalPadding: Dp = 24.dp,
    contentColor: Color = Color.White,
    text: String = "",
    @DrawableRes leadingIconId: Int? = R.drawable.ic_arrow_left,
    @DrawableRes trailingIconId: Int? = null,
    trailingIcons: @Composable (RowScope.() -> Unit)? = null,
    leadingIconOnClick: () -> Unit,
    trailingIconOnClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leadingIconId != null) {
            Icon(
                modifier = Modifier
                    .size(22.dp)
                    .clickable { leadingIconOnClick() },
                painter = painterResource(id = leadingIconId),
                contentDescription = null,
                tint = contentColor,
            )
        }
        Spacer(modifier = Modifier.width(13.dp))
        AppText(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = contentColor,
        )
        Spacer(modifier = Modifier.weight(1f))
        if (trailingIconId != null && trailingIcons == null) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(
                        color = Color.White.copy(0.30f),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable { trailingIconOnClick?.invoke() }
            ) {
                Icon(
                    modifier = Modifier
                        .width(15.dp)
                        .height(14.9.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = trailingIconId),
                    contentDescription = null,
                    tint = contentColor,
                )
            }
        } else if (trailingIcons != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                trailingIcons()
            }
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    EventBookingAppTheme {
        Surface(
            color = Color.Black
        ) {
            TopAppBar(
                text = "Event Details",
                trailingIconId = R.drawable.ic_bookmark,
                leadingIconOnClick = {

                },
            ) {

            }
        }
    }
}