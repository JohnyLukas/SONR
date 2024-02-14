package com.johnydev.sonr.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val screen: Screen,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {

    data object Home :
        NavigationItem(
            screen = Screen.NewsFeed,
            title = "Главная",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        )

    data object Messages :
        NavigationItem(
            screen = Screen.Messages,
            title = "Сообщения",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email
        )

    data object Profile :
        NavigationItem(
            screen = Screen.Profile,
            title = "Профиль",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle
        )

}