package com.nj.instagram.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nj.instagram.ui.auth.SignUpNavigationEvent
import com.nj.instagram.ui.auth.Login
import com.nj.instagram.ui.auth.LoginNavigationEvent
import com.nj.instagram.ui.auth.SignUp
import com.nj.instagram.ui.auth.SplashScreen
import com.nj.instagram.ui.auth.SplashScreenNavigation

@Composable
fun MainNavigationGraph()
{
    val navController= rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
        NavHost(navController = navController, startDestination = "splash", modifier = Modifier.padding(innerPadding))
        {
            composable("splash")
            {
                SplashScreen(
                    onNavigate = {event ->
                        when (event) {
                            SplashScreenNavigation.NavigateToHome->{

                            }
                            SplashScreenNavigation.NavigateToLogin->{

                            }
                        }
                    }
                )
            }
            composable("signup")
            {
                SignUp(
                    onNavigation = { event ->
                        when (event) {
                            SignUpNavigationEvent.LoggedOut -> {
                                navController.popBackStack()
                            }

                            SignUpNavigationEvent.onNavigateToLogin -> {
                                navController.popBackStack()
                            }

                            SignUpNavigationEvent.onSignUpSuccess -> {
                                navController.navigate("home") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        }
                    })
            }

            composable("signin")
            {
                Login(
                    onNavigation ={event ->
                when (event)
                {
                    LoginNavigationEvent.onLoginSuccess -> {

                    }
                    LoginNavigationEvent.onNavigateToSignUp -> {

                    }
                }}
                )
            }
            composable("home")
            {
                MainNavigation(navController)
            }
        }

    }
}