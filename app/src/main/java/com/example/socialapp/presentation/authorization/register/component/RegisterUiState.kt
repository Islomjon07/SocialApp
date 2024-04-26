package com.example.socialapp.presentation.authorization.register.component

import com.example.socialapp.presentation.utils.emptyString

data class RegisterUiState(
    val userFirstName: String = emptyString(),
    val userLastName: String = emptyString(),
    val userEmail: String = emptyString(),
    val userPassword: String = emptyString(),
)
