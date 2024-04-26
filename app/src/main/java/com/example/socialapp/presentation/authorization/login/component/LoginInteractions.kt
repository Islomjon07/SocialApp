package com.example.socialapp.presentation.authorization.login.component

import androidx.compose.runtime.Immutable

@Immutable
sealed interface LoginInteractions {

    @Immutable
    data class OnUserNameChanged(val userName: String) : LoginInteractions

    @Immutable
    data class OnUserPasswordChanged(val userPassword: String) : LoginInteractions

    data object OnLoginButtonClickEvent : LoginInteractions

    data object OnButtonClickSignUpScreen : LoginInteractions

}