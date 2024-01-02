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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.rashidsaleem.eventbookingapp.presentation.main.components.EventBookingAppNavHost
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventBookingAppMain(
    navController: NavHostController,
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show drawer") },
//                icon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_add_box),
//                        contentDescription = "",
//                    )
//                },
//                onClick = {
////                    coroutineScope.launch {
////
////                    }
//                }
//            )
//        }
    ) { paddingValues ->
        EventBookingAppNavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            )
    }
}


