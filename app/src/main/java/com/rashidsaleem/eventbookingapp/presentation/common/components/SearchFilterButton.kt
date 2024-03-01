package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue5
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue6
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun SearchFilterButton(
    containerColor: Color = Blue6,
    iconColor: Color = Blue5,
    textColor: Color = Color.White,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .background(color = containerColor, shape = RoundedCornerShape(50.dp))
            .clickable { onClick()  }
            .padding(4.dp)
            .padding(end = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.size(23.75.dp),
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            tint = iconColor,
        )
        Spacer(Modifier.width(3.7.dp))
        Text(
            text = stringResource(id = R.string.filters),
            fontFamily = airbnbCerealFontFamily,
            fontSize = 12.03.sp,
            fontWeight = FontWeight.Normal,
            color = textColor,
        )
    }
}