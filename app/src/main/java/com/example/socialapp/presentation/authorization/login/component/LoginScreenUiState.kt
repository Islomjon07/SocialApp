package com.example.socialapp.presentation.authorization.login.component

import androidx.compose.runtime.Immutable
import com.example.socialapp.presentation.utils.emptyString

@Immutable
data class LoginScreenUiState(
    val userName: String = emptyString(),
    val userPassword: String = emptyString(),
)