package com.rashidsaleem.eventbookingapp.presentation.resetPassword.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.BaseUiState
import com.rashidsaleem.eventbookingapp.presentation.resetPassword.ResetPasswordEvent
import com.rashidsaleem.eventbookingapp.presentation.resetPassword.ResetPasswordUiState
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray3
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ResetPasswordContent(
    baseUiState: BaseUiState,
    uiState: ResetPasswordUiState,
    onEvent: (ResetPasswordEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val buttonsHorizontalPadding = remember {
            16.dp
        }
        val buttonsVerticalPadding = remember {
            4.dp
        }

        val keyboardController = LocalSoftwareKeyboardController.current


        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {


            val (
                topAppBar, contentContainer, topRightCircle,
                bottomLeftCircle, bottomRightCircle) = createRefs()

            // Top-Right Circle
            Image(
                modifier = Modifier
                    .constrainAs(topRightCircle) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = R.drawable.img_top_right_background_circle),
                contentDescription = null
            )

            // Center-Right Circle
            Image(
                modifier = Modifier
                    .constrainAs(bottomLeftCircle) {
                        end.linkTo(parent.end)
                        centerVerticallyTo(parent)
                    },
                painter = painterResource(id = R.drawable.img_center_right_background_circle),
                contentDescription = null
            )

            // Bottom-Left Circle
//        Image(
//            modifier = Modifier
//                .constrainAs(bottomLeftCircle) {
//                    start.linkTo(parent.start)
//                    bottom.linkTo(parent.bottom)
//                },
//            painter = painterResource(id = R.drawable.img_bottom_left_background_circle),
//            contentDescription = null
//        )

            // Bottom-Right Circle
            Image(
                modifier = Modifier
                    .constrainAs(bottomRightCircle) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                painter = painterResource(id = R.drawable.img_bottom_right_background_circle),
                contentDescription = null
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 24.dp)
                    .constrainAs(topAppBar) {
                        top.linkTo(parent.top)
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onEvent(ResetPasswordEvent.NavigateBack)
                        },
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }

            Column(
                modifier = Modifier
                    .constrainAs(contentContainer) {
                        top.linkTo(topAppBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.resetPassword),
                    fontSize = 24.sp,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = Black2,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.please_enter_you_email_address_to_request_a_password_reset),
                    fontSize = 24.sp,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Black2,
                    lineHeight = 25.sp,
                )

                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.email,
                    onValueChange = { onEvent(ResetPasswordEvent.UpdateEmailValue(it)) },
                    placeholder = {
                        Text(
                            text = "abc@email.com",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Gray1,
                        )
                    },
                    leadingIcon = {
                        Icon(
                            modifier = Modifier.size(22.dp),
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = null,
                            tint = Gray3,
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Gray2,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                    )
                )
                Spacer(modifier = Modifier.height(36.dp))
                // SignIn Button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = buttonsHorizontalPadding),
                    onClick = {
                        keyboardController?.hide()
                        onEvent(ResetPasswordEvent.SendButtonOnClick)
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue
                    ),
                    shape = RoundedCornerShape(14.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp
                    ),
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = buttonsVerticalPadding),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = stringResource(id = R.string.send).uppercase(),
                            fontFamily = airbnbCerealFontFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Blue1, shape = CircleShape)
                                .size(30.dp)
                        ) {
                            Icon(
                                modifier = Modifier.align(Alignment.Center),
                                painter = painterResource(id = R.drawable.ic_arrow_right),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.Bottom,
//                ) {
//                    if (uiState.timerSeconds > 0) {
//                        Text(
//                            text = stringResource(id = R.string.resend_code_in),
//                            color = Black2,
//                            fontSize = 15.sp,
//                            fontFamily = airbnbCerealFontFamily,
//                            fontWeight = FontWeight.Normal,
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text(
//                            text = "00:${uiState.getTimerSecondsForDisplay()}",
//                            color = Blue,
//                            fontSize = 15.sp,
//                            fontFamily = airbnbCerealFontFamily,
//                            fontWeight = FontWeight.Normal,
//                        )
//                    } else {
//                        Text(
//                            modifier = Modifier
//                                .clickable {
//                                    onEvent(ResetPasswordEvent.SendVerificationCode)
//                                }
//                                .padding(4.dp),
//                            text = "Re-send Code",
//                            color = Blue,
//                            fontSize = 15.sp,
//                            fontFamily = airbnbCerealFontFamily,
//                            fontWeight = FontWeight.Normal,
//                        )
//                    }
//
//
//                }
//                Spacer(modifier = Modifier.height(24.dp))

            }

            // Loader Container
            if (baseUiState.showLoader) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black.copy(0.50f))
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.Center)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun ResetPasswordContentPreview() {

    val baseUiState by remember {
        mutableStateOf(
            BaseUiState()
        )
    }
    val uiState by remember {
        mutableStateOf(
            ResetPasswordUiState()
        )
    }


    EventBookingAppTheme {
        Surface {
            ResetPasswordContent(
                baseUiState = baseUiState,
                uiState = uiState,
                onEvent = {}
            )
        }
    }
}

