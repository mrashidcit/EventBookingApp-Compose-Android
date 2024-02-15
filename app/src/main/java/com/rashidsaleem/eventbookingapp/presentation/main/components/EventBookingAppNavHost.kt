package com.rashidsaleem.eventbookingapp.presentation.main.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.gson.Gson
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.common.enums.ProfileTypeEnum
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.codeVerification.CodeVerificationScreen
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.eventDetail.EventDetailScreen
import com.rashidsaleem.eventbookingapp.presentation.events.EventsScreen
import com.rashidsaleem.eventbookingapp.presentation.home.HomeScreen
import com.rashidsaleem.eventbookingapp.presentation.map.MapScreen
import com.rashidsaleem.eventbookingapp.presentation.notifications.NotificationsScreen
import com.rashidsaleem.eventbookingapp.presentation.onboarding.OnBoardingScreen
import com.rashidsaleem.eventbookingapp.presentation.profile.ProfileScreen
import com.rashidsaleem.eventbookingapp.presentation.resetPassword.ResetPasswordScreen
import com.rashidsaleem.eventbookingapp.presentation.signIn.SignInScreen
import com.rashidsaleem.eventbookingapp.presentation.signUp.SignUpScreen
import com.rashidsaleem.eventbookingapp.presentation.splash.SplashScreen
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import kotlinx.coroutines.flow.update

private const val TAG = "EventBookingAppNavHost"
@Composable
fun EventBookingAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController) {
    EventBookingAppTheme {
        NavHost(
            modifier = modifier,
            navController = navController,
//            startDestination = Routes.splash,
            startDestination = Routes.home,
//            startDestination = Routes.events,
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
                        Log.d(TAG, "OnBoardingScreen - navigateNext: $route")
                        navController.navigate(route)
                    },
                )
            }
            composable(Routes.signIn) {
                SignInScreen(
                    navigateNext = { route ->
                        navController.navigate(route)
                    }
                )
            }
            composable(Routes.signUp) {
                SignUpScreen(
                    navigateNext = { route ->
                        navController.navigate(route)
                    },
                    navigateBack = { route ->
                        if (route.isNotEmpty()) {
                            navController.popBackStack(
                                route = route,
                                inclusive = false,
                            )
                        } else {
                            navController.popBackStack()
                        }
                    }
                )
            }

            composable(Routes.home) {
                HomeScreen(
                    navController = navController,
                    navigateNext = { route, params ->
                        navController
                            .currentBackStackEntry
                            ?.savedStateHandle?.apply {
                                params?.let {
                                    val eventModelJson = it.getString(AppConstants.KEY_EVENT_MODEL) ?: ""
                                    val userId = it.getInt(AppConstants.KEY_PROFILE_ID, -1)

                                    this.set<String>(AppConstants.KEY_EVENT_MODEL, eventModelJson)
                                    this.set<Int>(AppConstants.KEY_PROFILE_ID, userId)
                                }
                            }
                        navController.navigate(route)
                    },
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(Routes.codeVerification) {
                CodeVerificationScreen(
                    navigateNext = { route ->
                        navController.navigate(route) {
                            popUpTo(Routes.codeVerification) {
                                inclusive = true
                            }
                        }
                    },
                    navigateBack = {
                        navController.popBackStack()
                    },
                )
            }

            composable(Routes.resetPassword) {
                ResetPasswordScreen(
                    navigateNext = { route ->
                        navController.navigate(route) {
                            popUpTo(Routes.resetPassword) {
                                inclusive = true
                            }
                        }
                    },
                    navigateBack = {
                        navController.popBackStack()
                    },
                )
            }
            composable(Routes.events) {
                EventsScreen(
                    navigateNext = { route, params ->
                        val eventJson = params.getString(AppConstants.KEY_EVENT_MODEL, "")
                        navController.currentBackStackEntry
                            ?.savedStateHandle
                            ?.set(AppConstants.KEY_EVENT_MODEL, eventJson)
                        navController.navigate(route)
                    },
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(Routes.map) {
                MapScreen(
                    navigateNext = { route, params ->

                        if (route == Routes.eventDetail) {
                            params.getString(AppConstants.KEY_EVENT_MODEL, "").let { event ->
                                navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.set(AppConstants.KEY_EVENT_MODEL, event)
                            }
                        }
                        navController.navigate(route)

                    },
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(Routes.profile) {
                val params = bundleOf()
                navController
                    .previousBackStackEntry
                    ?.savedStateHandle?.let { savedStateHandle ->
                        val profileId = savedStateHandle.get<Int>(AppConstants.KEY_PROFILE_ID) ?: -1
                        val profileType = savedStateHandle
                            .get<ProfileTypeEnum>(AppConstants.KEY_PROFILE_TYPE)
                            ?: ProfileTypeEnum.My
                        params.putInt(AppConstants.KEY_PROFILE_ID, profileId)
                        params.putSerializable(AppConstants.KEY_PROFILE_TYPE, profileType)

//                        val temp = params.getSerializable(AppConstants.KEY_PROFILE_TYPE) as ProfileTypeEnum?
//                        Log.d(TAG, "EventBookingAppNavHost: profileTypeEnum = ${temp?.name}")
                    }
                ProfileScreen(
                    params = params,
                    navigateNext = { route, params ->

                    },
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(Routes.notifications) {
                NotificationsScreen()
            }
            composable(Routes.eventDetail) {
                val eventJson = navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<String>(AppConstants.KEY_EVENT_MODEL) ?: ""
                val bundle = bundleOf().apply {
                    putString(AppConstants.KEY_EVENT_MODEL, eventJson)
                }
                EventDetailScreen(
                    bundle = bundle,
                    navigateBack = { navController.popBackStack() },
                    navigateNext = { route, params ->
                        params?.let {
                            val profileId = it.getInt(AppConstants.KEY_PROFILE_ID, -1)
                            if (profileId != -1) {
                                navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.apply {
                                        set(AppConstants.KEY_PROFILE_ID, profileId)
                                        set(AppConstants.KEY_PROFILE_TYPE, ProfileTypeEnum.My)
                                    }
                            }
                        }
                        navController.navigate(route)
                    }
                )
            }


        }
    }
}