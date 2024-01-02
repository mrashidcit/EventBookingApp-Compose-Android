package com.rashidsaleem.eventbookingapp.presentation.home.components.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rashidsaleem.eventbookingapp.R
import com.rashidsaleem.eventbookingapp.presentation.home.DrawerEnum
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.Aqua
import com.rashidsaleem.eventbookingapp.presentation.ui.theme.airbnbCerealFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(
    onClick: (DrawerEnum) -> Unit,
) {
    ModalDrawerSheet(
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (itemsList, bottomContainer) = createRefs()

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .constrainAs(itemsList) {
                        top.linkTo(parent.top)
                        bottom.linkTo(bottomContainer.top)
                    }
            ) {
                Spacer(Modifier.height(45.dp))
                Spacer(Modifier.height(45.dp))
                Image(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .size(60.dp)
                        .clip(CircleShape)
                        .clickable { onClick(DrawerEnum.ProfileIcon) }
                    ,
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
                    onClick = { onClick(DrawerEnum.MyProfile) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_message)
                    },
                    label = {
                        DrawerItemText(R.string.message)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.Message) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_calendar)
                    },
                    label = {
                        DrawerItemText(R.string.calendar)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.Calendar) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_bookmark)
                    },
                    label = {
                        DrawerItemText(R.string.bookmark)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.Bookmark) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_mail)
                    },
                    label = {
                        DrawerItemText(R.string.contact_us)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.ContactUs) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_settings)
                    },
                    label = {
                        DrawerItemText(R.string.settings)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.Settings) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_help)
                    },
                    label = {
                        DrawerItemText(R.string.helps_and_faqs)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.HelpsAndFaqs) }
                )
                NavigationDrawerItem(
                    icon = {
                        DrawerItemIcon(R.drawable.ic_sign_out)
                    },
                    label = {
                        DrawerItemText(R.string.sign_out)
                    },
                    selected = false,
                    onClick = { onClick(DrawerEnum.SignOut) }
                )

            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 26.dp)
                .padding(top = 10.dp, bottom = 35.39.dp)
                .constrainAs(bottomContainer) {
                    bottom.linkTo(parent.bottom)
                }
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            color = Aqua.copy(0.20f),
                            shape = RoundedCornerShape(8.dp),
                        )
                        .clickable {
                            onClick(DrawerEnum.UpgradePro)
                        }
                        .padding(horizontal = 17.39.dp, vertical = 13.29.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .width(21.dp)
                            .height(20.dp),
                        painter = painterResource(id = R.drawable.ic_upgrade_pro),
                        contentDescription = null,
                        tint = Aqua,
                    )
                    Spacer(modifier = Modifier.width(10.99.dp))
                    Text(
                        text = stringResource(id = R.string.upgrade_pro),
                        color = Aqua,
                        fontFamily = airbnbCerealFontFamily,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }

        }

    }
}