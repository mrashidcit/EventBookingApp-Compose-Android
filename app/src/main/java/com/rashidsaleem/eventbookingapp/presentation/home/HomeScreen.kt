package com.rashidsaleem.eventbookingapp.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.common.AppConstants
import com.rashidsaleem.eventbookingapp.common.AppUtil
import com.rashidsaleem.eventbookingapp.domain.models.home.EventModel
import com.rashidsaleem.eventbookingapp.presentation.common.dialogs.filter.FilterDialogView
import com.rashidsaleem.eventbookingapp.presentation.common.routes.Routes
import com.rashidsaleem.eventbookingapp.presentation.common.routes.listOfBottomNavItems
import com.rashidsaleem.eventbookingapp.presentation.home.components.HomeContent
import com.rashidsaleem.eventbookingapp.presentation.home.components.drawer.DrawerContent
import com.rashidsaleem.eventbookingapp.presentation.home.events.HomeTopContainerEvent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black5
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Blue8
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigateNext: (String, Bundle?) -> Unit,
    navigateBack: () -> Unit,
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val topContainerUiState by viewModel.topContainerUiState.collectAsState()
    val homeContentUiState by viewModel.homeContentUiState.collectAsState()
    val sheetState = androidx.compose.material3.rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    val _scope = rememberCoroutineScope()
    val mContext = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is HomeViewModel.UiEvent.NavigateNext -> navigateNext(event.route, event.params)
                HomeViewModel.UiEvent.NavigateBack -> navigateBack()
                is HomeViewModel.UiEvent.ShareInvitation -> AppUtil.shareMessage(
                    title = event.title,
                    description = event.description,
                    activity = mContext as ComponentActivity,
                )
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onClick = { value ->
                    when (value) {
                        DrawerEnum.ProfileIcon -> {
                            val params = bundleOf().apply {
                                putInt(AppConstants.KEY_PROFILE_ID, 1)
                            }
                            navigateNext(Routes.profile, params)
                        }
                        DrawerEnum.MyProfile -> {}
                        DrawerEnum.Message -> {}
                        DrawerEnum.Calendar -> {}
                        DrawerEnum.Bookmark -> {}
                        DrawerEnum.ContactUs -> {}
                        DrawerEnum.Settings -> {}
                        DrawerEnum.HelpsAndFaqs -> {}
                        DrawerEnum.SignOut -> {}
                        DrawerEnum.UpgradePro -> {}
                    }
                    coroutineScope.launch {
                        drawerState.close()
                    }

                },
            )
        },
    ) {
        Scaffold(
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                BottomNavigation(
                    backgroundColor = Color.White,
                    content = {
                        listOfBottomNavItems.forEach { screen ->
                            val selectedColor = Blue8
                            val unSelectedColor = Black5.copy(0.20f)
                            val isSelected = currentDestination
                                ?.hierarchy
                                ?.any { it.route == screen.route } == true
                            this.BottomNavigationItem(
                                icon = {
                                    Icon(
                                        modifier = Modifier.size(23.dp),
                                        painter = painterResource(
                                            id = screen.icon ?: R.drawable.ic_person,
                                        ),
                                        contentDescription = null,
                                        tint = if (isSelected) selectedColor else unSelectedColor
                                    )
                                },
                                label = {
                                    Column {
                                        Text(
                                            text = stringResource(screen.resourceId),
                                            color = if (isSelected) selectedColor else unSelectedColor
                                        )
                                    }
                                },
                                selectedContentColor = Blue8,
                                unselectedContentColor = Black5.copy(0.20f),
                                selected = isSelected,
//                                selected = screen.route == Routes.home, // Test Code
//                                selected = false, // Test Code
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            )
                        }


                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add_box),
                            contentDescription = "",
                            tint = Color.White
                        )
                    },
                    backgroundColor = Blue
                )
            },
            floatingActionButtonPosition = FabPosition.End,
        ) { contentPadding ->
            // Screen content
            HomeContent(
                modifier = Modifier.padding(contentPadding),
                topContainerUiState = topContainerUiState,
                homeContentUiState = homeContentUiState,
                topContainerOnEvent = { event ->
                    when (event) {
                        HomeTopContainerEvent.MenuIconClick -> {
                            coroutineScope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }

                        else -> {
                            viewModel.topContainerOnEvent(event)
                        }
                    }
                },
                homeContentOnEvent = { viewModel.homeContentOnEvent(it) }

            )

            // FilterDialog
            if (topContainerUiState.showFilterContainer) {
                ModalBottomSheet(
                    onDismissRequest = {
                        viewModel.topContainerOnEvent(
                            HomeTopContainerEvent.SearchFilterContainerClick(
                                false
                            )
                        )
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    FilterDialogView(
                        showDialog = {
                            _scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    viewModel.topContainerOnEvent(
                                        HomeTopContainerEvent.SearchFilterContainerClick(
                                            false
                                        )
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }

    }


}

@Preview
@Composable
fun HomeScreenPreview() {
    EventBookingAppTheme {
        Surface {
            val navController = rememberNavController()
            HomeScreen(
                navController = navController,
                navigateNext = { route, params -> },
                navigateBack = {},
            )
        }
    }
}