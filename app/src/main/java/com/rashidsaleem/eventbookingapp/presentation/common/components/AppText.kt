package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String? = null,
    @StringRes textResId: Int = R.string.hello,
    fontFamily: FontFamily = airbnbCerealFontFamily,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text ?: stringResource(id = textResId),
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        lineHeight = lineHeight
    )
}