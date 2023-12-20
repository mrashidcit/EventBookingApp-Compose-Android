package com.rashidsaleem.eventbookingapp.presentation.codeVerification

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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.rashidsaleem.eventbookingapp.presentation.codeVerification.components.CodeVerificationContent
import com.rashidsaleem.eventbookingapp.presentation.signIn.SignInEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray1
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray2
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray3
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Gray4
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeVerificationScreen(
    viewModel: CodeVerificationViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String) -> Unit,
    navigateBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {

        viewModel.onEvent(CodeVerificationEvent.SendVerificationCodeFirstTime)
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is CodeVerificationViewModel.UiEvent.NavigateNext -> navigateNext(event.route)
                CodeVerificationViewModel.UiEvent.NavigateBack -> navigateBack()
            }
        }
    }

    CodeVerificationContent(
        uiState = uiState,
        onEvent = { viewModel.onEvent(it) }
    )
}


