package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue9
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray10
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.SunsetOrange
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@Composable
fun HorizontalListItemButton(
    @DrawableRes icon: Int = R.drawable.ic_sports,
    @StringRes stringResId: Int = R.string.sports,
    containerColor: Color? = null,
    contentColor: Color? = null,
    iconColor: Color? = null,
    textColor: Color? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
            containerColor = containerColor ?: SunsetOrange,
            contentColor = contentColor ?: Color.White
        ),
    onClick: () -> Unit,
) {
    Button(
        shape = RoundedCornerShape(24.dp),
        onClick = onClick,
        colors = colors
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 0.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                modifier = Modifier.size(17.73.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = iconColor ?: contentColor ?: Color.White
            )
            Spacer(Modifier.width(8.31.dp))
            Text(
                text = stringResource(id = stringResId),
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Normal,
                color = textColor ?: contentColor ?: Color.White,
            )
        }
    }
}

@Preview
@Composable
fun HorizontalListItemButtonPreview() {
    EventBookingAppTheme {
        Surface {
            HorizontalListItemButton(
                icon = R.drawable.ic_music,
                iconColor = Blue9,
                textColor = Gray10,
                stringResId = R.string.music,
                containerColor = Color.White,
            ) {

            }
        }
    }
}

