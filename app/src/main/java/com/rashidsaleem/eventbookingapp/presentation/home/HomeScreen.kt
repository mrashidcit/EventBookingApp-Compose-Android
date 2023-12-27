package com.rashidsaleem.eventbookingapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rashidsaleem.eventbookingapp.presentation.home.components.drawer.DrawerContent
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(onClick = { value ->
                when(value) {
                    DrawerEnum.ProfileIcon -> {}
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
                scope.launch {
                    drawerState.close()
                }

            })
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(contentPadding)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "Home",
                        fontSize = 40.sp,
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
            HomeScreen()
        }
    }
}