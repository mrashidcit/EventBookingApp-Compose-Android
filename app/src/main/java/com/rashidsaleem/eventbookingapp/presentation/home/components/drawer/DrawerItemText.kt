package com.rashidsaleem.eventbookingapp.presentation.home.components.drawer

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun DrawerItemText(
    @StringRes text: Int = R.string.my_profile,
) {
    Text(
        text = stringResource(id = text),
        fontSize = 16.sp,
        fontFamily = airbnbCerealFontFamily,
        fontWeight = FontWeight.Normal,
        color = Black
    )
}