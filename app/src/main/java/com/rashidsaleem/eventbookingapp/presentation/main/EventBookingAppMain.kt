package com.rashidsaleem.eventbookingapp.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.common.routes.listOfBottomNavItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventBookingAppMain(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            BottomNavigation {
                listOfBottomNavItems.forEach { screen ->
                    this.BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = screen.icon ?: R.drawable.ic_person),
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination
                            ?.hierarchy
                            ?.any { it.route == screen.route } == true,
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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show drawer") },
                icon = { androidx.compose.material3.Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}

@Preview
@Composable
fun EventBookingAppMainPreview(navController: NavHostController) {

}

