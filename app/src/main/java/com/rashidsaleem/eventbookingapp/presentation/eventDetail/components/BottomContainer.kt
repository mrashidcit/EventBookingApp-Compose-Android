package com.rashidsaleem.eventbookingapp.presentation.eventDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppText
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

@Composable
fun BottomContainer(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 23.dp, horizontal = 52.dp)
    ) {
        Button(
            modifier = Modifier
                .height(58.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Blue
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
            ) {

                val (text, icon) = createRefs()

                AppText(
                    modifier = Modifier.constrainAs(text) {
                        centerVerticallyTo(parent)
                        centerHorizontallyTo(parent)
                    },
                    text = stringResource(id = R.string.buy_ticket) + " $120",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                )
                Box(
                    modifier = Modifier
                        .background(color = Blue1, shape = CircleShape)
                        .constrainAs(icon) {
                            centerVerticallyTo(parent)
                            end.linkTo(parent.end)
                        }
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 8.dp, bottom = 9.dp, end = 9.dp)
                            .size(13.dp),
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BottomContainerPreview() {
    EventBookingAppTheme {
        Surface {
            BottomContainer() {

            }
        }
    }
}

