package com.rashidsaleem.eventbookingapp.presentation.signUp.components

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.components.AppCircularProgressIndicator
import com.rashidsaleem.eventbookingapp.presentation.signUp.SignUpEvent
import com.rashidsaleem.eventbookingapp.presentation.signUp.SignUpUiState
import com.rashidsaleem.eventbookingapp.presentation.signUp.SignUpViewModel
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray3
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpContent(
    uiState: SignUpUiState,
    onEvent: (SignUpEvent) -> Unit,
) {
    val buttonsHorizontalPadding = remember {
        16.dp
    }
    val buttonsVerticalPadding = remember {
        4.dp
    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {


        val (
            topAppBar, contentContainer, topRightCircle,
            bottomLeftCircle, bottomRightCircle,
            ) = createRefs()

        // Blue box for testing
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .background(color = Blue)
//        ) {
//
//        }

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

        // Yellow Box for Testing
//        Box(modifier = Modifier
//            .padding(top = 50.dp)
//            .fillMaxWidth()
//            .height(100.dp)
//            .background(color = Yellow)
//        ) {
//
//        }

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

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .constrainAs(topAppBar) {
                    top.linkTo(parent.top)
                }
        ) {
            Icon(
                modifier = Modifier.size(24.dp)
                    .clickable {
                       onEvent(SignUpEvent.BackButtonOnClick)
                    },
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = null,
                )
        }

        Column(
            modifier = Modifier
                .constrainAs(contentContainer) {
                    top.linkTo(topAppBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.signin),
                fontSize = 24.sp,
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Medium,
                color = Black2,
            )
            Spacer(modifier = Modifier.height(10.dp))
            // Full Name
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.fullName,
                onValueChange = { onEvent(SignUpEvent.UpdateFullNameValue(it)) },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.full_name),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Gray1,
                    )
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = null,
                        tint = Gray3,
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Gray2
                )
            )
            Spacer(modifier = Modifier.height(14.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                onValueChange = { onEvent(SignUpEvent.UpdateEmailValue(it)) },
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
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Gray2
                )
            )
            Spacer(modifier = Modifier.height(14.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                onValueChange = { onEvent(SignUpEvent.UpdatePasswordValue(it)) },
                visualTransformation = if (uiState.passwordVisibility)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                placeholder = {
                    Text(
                        text = "Your password",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Gray1,
                    )
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        tint = Gray3,
                    )
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable {
                                onEvent(
                                    SignUpEvent.UpdatePasswordVisibility(
                                        !uiState.passwordVisibility
                                    )
                                )
                            },
                        painter = painterResource(
                            id =
                            if (!uiState.passwordVisibility)
                                R.drawable.ic_eye_visibility_off
                            else
                                R.drawable.baseline_visibility_24
                        ),
                        contentDescription = null,
                        tint = Gray3,
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Gray2
                )
            )
            Spacer(modifier = Modifier.height(14.dp))
            // Confirm Password
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.confirmPassword,
                onValueChange = { onEvent(SignUpEvent.UpdateConfirmPasswordValue(it)) },
                visualTransformation = if (uiState.confirmPasswordVisibility)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.confirm_password),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Gray1,
                    )
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(22.dp),
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        tint = Gray3,
                    )
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .clickable {
                                onEvent(
                                    SignUpEvent.UpdateConfirmPasswordVisibility(
                                        !uiState.confirmPasswordVisibility
                                    )
                                )
                            },
                        painter = painterResource(
                            id =
                            if (!uiState.confirmPasswordVisibility)
                                R.drawable.ic_eye_visibility_off
                            else
                                R.drawable.baseline_visibility_24
                        ),
                        contentDescription = null,
                        tint = Gray3,
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Gray2
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Switch(
                    checked = uiState.rememberMeCheck,
                    onCheckedChange = { onEvent(SignUpEvent.UpdateRememberMeCheck(it)) },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = Blue,
                    ),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.rememberMe),
                    fontSize = 14.sp,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Black2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.forgotPassword),
                    fontSize = 14.sp,
                    fontFamily = airbnbCerealFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Black2,
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            // SignIn Button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = buttonsHorizontalPadding),
                onClick = { onEvent(SignUpEvent.SignUpOnClick) },
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
                        text = stringResource(id = R.string.signUp).uppercase(),
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
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.or).uppercase(),
                fontSize = 18.sp,
                fontFamily = airbnbCerealFontFamily,
                fontWeight = FontWeight.Medium,
                color = Gray4,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            // Google Login Button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = buttonsHorizontalPadding),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
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

                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = stringResource(id = R.string.loginWithGoogle),
                        fontFamily = airbnbCerealFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Black2,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Facebook Login Button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = buttonsHorizontalPadding),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
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

                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = stringResource(id = R.string.loginWithFacebook),
                        fontFamily = airbnbCerealFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Black2,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.alreadyHaveAnAccount),
                    fontFamily = airbnbCerealFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Black2,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    modifier = Modifier.clickable { onEvent(SignUpEvent.SignInOnClick) },
                    text = stringResource(id = R.string.signin),
                    fontFamily = airbnbCerealFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue,
                    textAlign = TextAlign.Center,
                )

            }
            Spacer(modifier = Modifier.height(36.dp))
        }

        // Loader Container
        if (uiState.isLoading) {
            AppCircularProgressIndicator()
        }

    }
}


@Preview
@Composable
fun SignUpContentPreview() {
    EventBookingAppTheme {

        val uiState by remember {
            mutableStateOf(
                SignUpUiState()
            )
        }

        Surface {
            SignUpContent(uiState = uiState, onEvent = {})
        }
    }
}


