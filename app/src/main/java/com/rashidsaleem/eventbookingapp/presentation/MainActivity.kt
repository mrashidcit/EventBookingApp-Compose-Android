package com.rashidsaleem.eventbookingapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.codeVerification.CodeVerificationScreen
import com.rashidsaleem.eventbookingapp.presentation.home.HomeScreen
import com.rashidsaleem.eventbookingapp.presentation.main.EventBookingAppMain
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnBoardingScreen
import com.rashidsaleem.eventbookingapp.presentation.resetPassword.ResetPasswordScreen
import com.rashidsaleem.eventbookingapp.presentation.signIn.SignInScreen
import com.rashidsaleem.eventbookingapp.presentation.signUp.SignUpScreen
import com.rashidsaleem.eventbookingapp.presentation.splash.SplashScreen
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            EventBookingAppMain(
                navController
            )

        }
    }



}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventBookingAppTheme {
        Greeting("Android")
    }
}