package com.nj.instagram.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nj.instagram.R
import com.nj.instagram.ui.theme.ColorBackground
import com.nj.instagram.ui.theme.ColorBorder
import com.nj.instagram.ui.theme.ColorDivider
import com.nj.instagram.ui.theme.ColorOnBackground
import com.nj.instagram.ui.theme.ColorPrimary
import com.nj.instagram.ui.theme.ColorPrimaryDisabled
import com.nj.instagram.ui.theme.ColorSurfaceVariant
import com.nj.instagram.ui.theme.Medium14
import com.nj.instagram.ui.theme.SemiBold14
import com.nj.instagram.ui.theme.White

sealed class LoginNavigationEvent {
    object onLoginSuccess : LoginNavigationEvent()
    object onNavigateToSignUp : LoginNavigationEvent()
}

@Composable
fun Login(viewModel: AuthViewModel = hiltViewModel(),onNavigation:(LoginNavigationEvent)->Unit)
{
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App Logo
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Light,
            fontSize = 48.sp,
            letterSpacing = 2.sp,
            color = ColorOnBackground,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        Spacer(Modifier.height(16.dp))

        // Email TextField
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    text = "Phone number, username or email",
                    style = MaterialTheme.typography.Medium14
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.Medium14,
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = ColorBorder,
                focusedBorderColor = ColorBorder,
                unfocusedContainerColor = ColorSurfaceVariant,
                focusedContainerColor = ColorBackground
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", style = MaterialTheme.typography.Medium14) },
           // visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = ColorOnBackground,
                        modifier = Modifier.size(18.dp)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.Medium14,
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = ColorBorder,
                focusedBorderColor = ColorBorder,
                unfocusedContainerColor = ColorSurfaceVariant,
                focusedContainerColor = ColorBackground
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Login Button
        Button(
            onClick = { viewModel.login(email, password) },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.isNotEmpty() && password.isNotEmpty() && uiState !is AuthUiState.Loading,
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorPrimary,
                disabledContainerColor = ColorPrimaryDisabled
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            if (uiState is AuthUiState.Loading) {
                CircularProgressIndicator(
                    color = ColorBackground,
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Text(
                    "Log in",
                    style = MaterialTheme.typography.SemiBold14,
                    color = White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // OR Divider
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(ColorDivider)
            )
            Text(
                "OR",
                modifier = Modifier.padding(horizontal = 16.dp))

        }
    }
}