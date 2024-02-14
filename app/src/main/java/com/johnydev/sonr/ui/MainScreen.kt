package com.johnydev.sonr.ui

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.johnydev.sonr.MainViewModel
import com.johnydev.sonr.ui.navigation.AppNavGraph
import com.johnydev.sonr.ui.navigation.NavigationItem

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Messages,
                    NavigationItem.Profile
                )

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.screen.route,
                        onClick = { navHostController.navigate(route = item.screen.route) },
                        icon = {
                            Icon(
                                imageVector = if (currentRoute == item.screen.route) item.selectedIcon
                                else item.unselectedIcon, contentDescription = item.title
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                color = if (currentRoute == item.screen.route) Color.Magenta else Color.Black
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navHostController,
            homeScreenContent = {
                HomeScreen(
                    viewModel = viewModel,
                    paddingValues = paddingValues
                )
            },
            messagesScreenContent = { TextCounter("Messages") },
            profileScreenContent = { TextCounter("Profile") }
        )
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Text(modifier = Modifier.clickable { count++ }, text = "$name Count: $count", fontSize = 24.sp)
}