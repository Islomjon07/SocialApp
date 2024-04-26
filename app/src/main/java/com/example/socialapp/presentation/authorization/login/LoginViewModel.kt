package com.example.socialapp.presentation.authorization.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.login.UserLoginUseCase
import com.example.socialapp.presentation.authorization.login.component.LoginInteractions
import com.example.socialapp.presentation.authorization.login.component.LoginScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: UserLoginUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<LoginScreenUiState> =
        MutableStateFlow(LoginScreenUiState())
    val uiState: StateFlow<LoginScreenUiState> = _uiState.asStateFlow()

    private val _navigateUpFlow: MutableStateFlow<Unit> = MutableStateFlow(Unit)
    val navigateUpFlow: StateFlow<Unit> = _navigateUpFlow.asStateFlow()

    fun onInteraction(interaction: LoginInteractions) {
        when (interaction) {
            is LoginInteractions.OnLoginButtonClickEvent -> doUserLoginRequest()
            is LoginInteractions.OnUserPasswordChanged -> onUpdatePassword(interaction)
            is LoginInteractions.OnUserNameChanged -> onUpdateUserName(interaction)
            is LoginInteractions.OnButtonClickSignUpScreen -> TODO()
        }
    }

    private fun onUpdatePassword(interaction: LoginInteractions.OnUserPasswordChanged) {
        _uiState.update { newState ->
            newState.copy(
                userPassword = interaction.userPassword
            )
        }
    }

    private fun onUpdateUserName(interaction: LoginInteractions.OnUserNameChanged) {
        _uiState.update { newState ->
            newState.copy(
                userName = interaction.userName
            )
        }
    }

    private fun doUserLoginRequest() {
        viewModelScope.launch {
            val response = loginUseCase(
                username = _uiState.value.userName,
                userPassword = _uiState.value.userPassword
            )
            if (response.isSuccess) { }
            else { }
        }
    }
}