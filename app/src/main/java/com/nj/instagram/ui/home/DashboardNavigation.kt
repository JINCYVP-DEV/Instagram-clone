package com.nj.instagram.ui.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

sealed class MainScreen(val route: String)
{
    object MainGraph: MainScreen("main_graph")
    object Home: MainScreen("home")
}

fun NavGraphBuilder.dashboardScreenGraph(navHostController: NavHostController)
{
    navigation(route = MainScreen.MainGraph.route, startDestination = MainScreen.Home.route)
    {
        composable(MainScreen.Home.route)
        {
            HomeNavigation(navHostController)
        }
        //if we need screens without bottombar ie settings
//        composable("settings")
//        {
//
//        }
    }
}