package com.rashidsaleem.eventbookingapp.presentation.home.components.drawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rashidsaleem.eventbookingapp.R

@Composable
fun DrawerItemIcon(
    @DrawableRes icon: Int = R.drawable.ic_message,
) {
    Icon(
        modifier = Modifier.padding(start = 16.dp),
        painter = painterResource(id = icon),
        contentDescription = null,
    )
}