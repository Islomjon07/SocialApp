package com.example.socialapp.presentation.authorization.register.component

import androidx.compose.runtime.Immutable

@Immutable
sealed interface RegisterInteraction {

    @Immutable
    data class OnUserFirstNameChanger(val userFirstName: String) : RegisterInteraction

    @Immutable
    data class OnUserLastNameChanger(val userLastName: String) : RegisterInteraction

    @Immutable
    data class OnUserEmailChanger(val userEmail: String) : RegisterInteraction

    @Immutable
    data class OnUserPasswordChanger(val userPassword: String) : RegisterInteraction

    data object OnNavigatePopBackStack : RegisterInteraction

    data object OnRegisterButtonClick : RegisterInteraction
}