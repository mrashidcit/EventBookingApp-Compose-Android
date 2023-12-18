package com.rashidsaleem.eventbookingapp.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppCircularProgressIndicator(
    progressModifier: Modifier = Modifier
        .size(60.dp)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(0.50f))
    ) {
        CircularProgressIndicator(
            modifier = progressModifier
                .align(Alignment.Center)
        )
    }
}