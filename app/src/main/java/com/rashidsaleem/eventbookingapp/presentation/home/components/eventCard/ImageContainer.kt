package com.rashidsaleem.eventbookingapp.presentation.home.components.eventCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.SunsetOrange

@Composable
fun ImageContainer() {
    ConstraintLayout(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp)),
    ) {

        val (date, bookmark) = createRefs()

        Image(
            modifier = Modifier
                .width(218.dp)
                .height(132.dp),
            painter = painterResource(id = R.drawable.img_card1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 6.dp, vertical = 6.dp)
                .constrainAs(date) {
                    start.linkTo(parent.start, 7.dp)
                    top.linkTo(parent.top, 9.dp)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppText(
                text = "10",
                color = SunsetOrange,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            AppText(
                text = "JUNE",
                color = SunsetOrange,
                fontSize = 10.sp,
            )

        }

        Column(
            modifier = Modifier
                .size(30.dp)
                .background(color = Color.White, shape = RoundedCornerShape(7.dp))
                .constrainAs(bookmark) {
                    end.linkTo(parent.end, 9.dp)
                    top.linkTo(parent.top, 9.dp)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.size(14.1.dp),
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = null,
                tint = SunsetOrange
            )
        }


    }
}