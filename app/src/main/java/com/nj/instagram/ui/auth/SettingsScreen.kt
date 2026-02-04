package com.nj.instagram.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel

sealed class SettingsScreenNavigationEvents{
    object NavigateToLogin: SettingsScreenNavigationEvents()
}
@Composable
fun SettingsScreen(authViewModel: AuthViewModel= hiltViewModel(),onNavigation:(SettingsScreenNavigationEvents)->Unit)
{
    var showLogout by rememberSaveable { mutableStateOf(false) }
    //observe authViewmodel state
    LaunchedEffect(authViewModel.authEvents) {
        authViewModel.authEvents.collect {event ->
            if (event is AuthViewModel.AuthEvent.LoggedOut)
            {
                onNavigation(SettingsScreenNavigationEvents.NavigateToLogin)
            }
        }
    }
}