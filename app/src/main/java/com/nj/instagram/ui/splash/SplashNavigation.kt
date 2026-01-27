package com.nj.instagram.ui.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.nj.instagram.ui.auth.AuthScreen


object SplashNavigation{
    val route: String="splash_route"
}
fun NavGraphBuilder.splashGraph(navHostController: NavHostController)
{
    composable(SplashNavigation.route)
    {
        SplashScreen(
            onNavigate = {event ->
                when (event) {
                    SplashScreenNavigation.NavigateToHome->{
                        navHostController.navigate("home")
                    }
                    SplashScreenNavigation.NavigateToLogin->{
                        navHostController.navigate(AuthScreen.Login.route)
                    }
                }
            }
        )
    }
}