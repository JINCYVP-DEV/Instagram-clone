package com.nj.instagram.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    //sessionManager: SessionManager
)
    : ViewModel() {
    val authState_: MutableStateFlow<AuthState> = MutableStateFlow(AuthState.LOGGED_IN)
    val authState: StateFlow<AuthState> = authState_

//        sessionManager.isLoggedInFlow
//        .map { if (it) AuthState.LOGGED_IN else AuthState.LOGGED_OUT }
//        .stateIn(viewModelScope, SharingStarted.Eagerly, AuthState.LOADING)


}