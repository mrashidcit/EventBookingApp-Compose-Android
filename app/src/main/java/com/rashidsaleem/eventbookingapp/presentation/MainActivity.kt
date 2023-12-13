package com.rashidsaleem.eventbookingapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rashidsaleem.eventbookingapp.common.Routes
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnBoardingScreen
import com.rashidsaleem.eventbookingapp.presentation.signIn.SignInScreen
import com.rashidsaleem.eventbookingapp.presentation.splash.SplashScreen
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            EventBookingAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = Routes.splash,
                ) {
                    composable(Routes.splash) {
                        SplashScreen(
                            navigateNext = { route ->
                                navController.navigate(route)
                            }
                        )
                    }
                    composable(Routes.onboarding) {
                        OnBoardingScreen(
                            navigateNext = { route ->
                                navController.navigate(route)
                            },
                        )
                    }
                    composable(Routes.signIn) {
                        SignInScreen()
                    }
                }
            }
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