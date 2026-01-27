package com.nj.instagram.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nj.instagram.nav.postNestedGraph

@Composable
fun HomeNavigation(rootNavController: NavHostController)
{
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val shouldShowBottomBar = navBackStackEntry?.destination?.hierarchy?.none{
        it.route=="post_graph"
    }==true

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar)
            {
                NavigationBar {
                    NavigationBarItem(
                        selected = selectedTab==0,
                        onClick = {
                            selectedTab=0
                            navController.navigate("home"){launchSingleTop=true}
                        },
                        icon ={ Icon(Icons.Default.Home,"Home")},
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.VideoLibrary, "Reels") },
                        label = { Text("Reels") },
                        selected = selectedTab == 1,
                        onClick = {
                            selectedTab = 1
                            navController.navigate("reels") { launchSingleTop = true }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.NearMe, "Message") },
                        label = { Text("Message") },
                        selected = selectedTab == 2,
                        onClick = {
                            selectedTab = 2
                            navController.navigate("message") { launchSingleTop = true }
                        }
                    )
                    NavigationBarItem(
                        selected = selectedTab==3,
                        onClick = {
                            selectedTab=3
                            navController.navigate("search"){launchSingleTop=true}
                        },
                        icon = {Icon(Icons.Default.Search,"Search")},
                        label = {Text("Search")}
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, "Profile") },
                        label = { Text("Profile") },
                        selected = selectedTab == 4,
                        onClick = {
                            selectedTab = 4
                            navController.navigate("profile") { launchSingleTop = true }
                        }
                    )
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(bottom = padding.calculateBottomPadding())) {
            NavHost(navController = navController, startDestination = "home")
            {
                composable("home")
                {
                    HomeScreen()
                }
                postNestedGraph(navController)
            }
        }

    }
}