package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Black,
    textFontSize: TextUnit = TextUnit.Unspecified,
    textFontWeight: FontWeight = FontWeight.Normal,
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors =  ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    border: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        colors = colors,
        contentPadding = contentPadding,
        border = border,
        elevation = elevation
    ) {
        AppText(
            text = text,
            color = textColor,
            fontSize = textFontSize,
            fontWeight = textFontWeight,
        )
    }
}