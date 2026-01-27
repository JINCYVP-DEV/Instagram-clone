package com.nj.instagram.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nj.instagram.ui.auth.authNavigationGraph
import com.nj.instagram.ui.home.dashboardScreenGraph
import com.nj.instagram.ui.splash.SplashNavigation
import com.nj.instagram.ui.splash.splashGraph

@Composable
fun InstaNavigationGraph()
{
    val navController= rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
        NavHost(navController = navController, startDestination = SplashNavigation.route, modifier = Modifier.padding(innerPadding))
        {
            splashGraph(navController)
            authNavigationGraph(navController)
            dashboardScreenGraph(navController )
        }
    }
}