package com.nj.instagram.ui.auth

import androidx.lifecycle.ViewModel
import com.nj.instagram.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
)  : ViewModel(){

//    // Single-event channel
//    private val _authEvents = MutableSharedFlow<AuthEvent>()
//    val authEvents = _authEvents.asSharedFlow()
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

}