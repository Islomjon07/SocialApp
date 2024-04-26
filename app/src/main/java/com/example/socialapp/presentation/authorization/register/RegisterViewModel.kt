package com.example.socialapp.presentation.authorization.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UserSignDomainModel
import com.example.domain.repository.UserAuthRepository
import com.example.socialapp.presentation.authorization.nav.graph.MAIN_NAV_GRAPH
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction.OnNavigatePopBackStack
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction.OnRegisterButtonClick
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction.OnUserEmailChanger
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction.OnUserFirstNameChanger
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction.OnUserLastNameChanger
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction.OnUserPasswordChanger
import com.example.socialapp.presentation.authorization.register.component.RegisterUiState
import com.example.socialapp.presentation.manager.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRegister: UserAuthRepository,
    private val navigationManager: NavigationManager
) : ViewModel() {

    private val _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    private val _navigateUpFlow: MutableStateFlow<Unit> = MutableStateFlow(Unit)
    val navigateUpFlow: StateFlow<Unit> = _navigateUpFlow.asStateFlow()

    fun onInteraction(interaction: RegisterInteraction) {
        when (interaction) {
            is OnNavigatePopBackStack -> _navigateUpFlow
            is OnUserFirstNameChanger -> onUpdateFirstName(interaction)
            is OnUserLastNameChanger -> onUpdateLastname(interaction)
            is OnUserEmailChanger -> onUpdateUserEmail(interaction)
            is OnUserPasswordChanger -> onUpdateUserPassword(interaction)
            is OnRegisterButtonClick -> doClickButton()
        }
    }

    private fun onUpdateFirstName(interaction: OnUserFirstNameChanger) {
        _uiState.update { newState ->
            newState.copy(
                userFirstName = interaction.userFirstName
            )
        }
    }

    private fun onUpdateLastname(interaction: OnUserLastNameChanger) {
        _uiState.update { newState ->
            newState.copy(
                userLastName = interaction.userLastName

            )
        }
    }

    private fun onUpdateUserEmail(interaction: OnUserEmailChanger) {
        _uiState.update { newState ->
            newState.copy(
                userEmail = interaction.userEmail
            )
        }
    }

    private fun onUpdateUserPassword(interaction: OnUserPasswordChanger) {
        _uiState.update { newState ->
            newState.copy(
                userPassword = interaction.userPassword
            )
        }
    }

    private fun doClickButton(): Unit = with(_uiState.value) {
        if (!validateUserInfoTexts(listOf(userFirstName, userEmail, userLastName, userPassword))) {
            return
        }
        viewModelScope.launch {
            val request = userRegister.register(
                UserSignDomainModel(
                    userEmail = userEmail,
                    userPassword = userPassword,
                    userLastName = userLastName,
                    userFirstName = userFirstName,
                    userName = userEmail
                )
            )
            if (request.isSuccess){
                navigationManager.navigateTo(MAIN_NAV_GRAPH,isBackStackClear = true)
            }
        }
    }

    private fun validateUserInfoTexts(texts: List<String>): Boolean {
        var isValidateTexts = false
        texts.forEach {
            if (it.isNotEmpty()) {
                isValidateTexts = true
            }
        }
        return isValidateTexts
    }
}