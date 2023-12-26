package com.rashidsaleem.eventbookingapp.presentation.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Aqua
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Black
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.EventBookingAppTheme
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
            ) {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (itemsList, bottomContainer) = createRefs()

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(start = 24.dp, top = 45.dp)
                                .size(60.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.img_person_1),
                            contentDescription = null,
                        )
                        Text(
                            text = "Rashid Saleem",
                            modifier = Modifier
                                .padding(16.dp)
                                .padding(start = 10.dp),
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = airbnbCerealFontFamily,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_my_profile)
                            },
                            label = {
                                DrawerItemText(R.string.my_profile)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_message)
                            },
                            label = {
                                DrawerItemText(R.string.message)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_calendar)
                            },
                            label = {
                                DrawerItemText(R.string.calendar)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_bookmark)
                            },
                            label = {
                                DrawerItemText(R.string.bookmark)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_mail)
                            },
                            label = {
                                DrawerItemText(R.string.contact_us)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_settings)
                            },
                            label = {
                                DrawerItemText(R.string.settings)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_help)
                            },
                            label = {
                                DrawerItemText(R.string.helps_and_faqs)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        NavigationDrawerItem(
                            icon = {
                                DrawerItemIcon(R.drawable.ic_sign_out)
                            },
                            label = {
                                DrawerItemText(R.string.sign_out)
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .width(21.dp)
                                .height(20.dp),
                            painter = painterResource(id = R.drawable.ic_upgrade_pro),
                            contentDescription = null,
                        )
                        Text(
                            text = stringResource(id = R.string.upgrade_pro),
                            color = Aqua
                        )
                    }

                }

            }
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

@Composable
private fun DrawerItemIcon(
    @DrawableRes icon: Int = R.drawable.ic_message,
) {
    Icon(
        modifier = Modifier.padding(start = 16.dp),
        painter = painterResource(id = icon),
        contentDescription = null,
    )
}

@Composable
private fun DrawerItemText(
    @StringRes text: Int = R.string.my_profile,
) {
    Text(
        text = stringResource(id = text),
        fontSize = 16.sp,
        fontFamily = airbnbCerealFontFamily,
        fontWeight = FontWeight.Normal,
        color = Black
    )
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