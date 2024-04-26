package com.example.socialapp.presentation.authorization.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialapp.R
import com.example.socialapp.presentation.authorization.components.AuthComponentBtn
import com.example.socialapp.presentation.authorization.components.SignToolBarComponent
import com.example.socialapp.presentation.authorization.components.SocialTextFieldComponent
import com.example.socialapp.presentation.authorization.register.component.RegisterInteraction
import com.example.socialapp.presentation.authorization.register.component.RegisterUiState
import com.example.socialapp.presentation.theme.PurpleBlack
import com.example.socialapp.presentation.theme.dp20
import com.example.socialapp.presentation.theme.dp40
import kotlinx.coroutines.flow.StateFlow


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onInteraction: (RegisterInteraction) -> Unit,
    uiStateFlow: StateFlow<RegisterUiState>,
    callBackInSuccessMainScreen: () -> Unit
) {
    val uiState: RegisterUiState = uiStateFlow.collectAsState().value
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PurpleBlack)
            .padding(horizontal = dp20)
    ) {
        Column {
            SignToolBarComponent(
                onIconClick = { onInteraction(RegisterInteraction.OnNavigatePopBackStack) },
                text = stringResource(R.string.sign_up),
            )
            Spacer(modifier = modifier.height(dp20))
            SocialTextFieldComponent(
                text = uiState.userFirstName,
                onValueChange = {
                    onInteraction(RegisterInteraction.OnUserFirstNameChanger(it))
                },
                labelText = "FirstName"
            )
            SocialTextFieldComponent(
                text = uiState.userLastName,
                onValueChange = {
                    onInteraction(RegisterInteraction.OnUserLastNameChanger(it))
                },
                labelText = "LastName"
            )
            SocialTextFieldComponent(
                text = uiState.userEmail,
                onValueChange = {
                    onInteraction(RegisterInteraction.OnUserEmailChanger(it))
                },
                labelText = "Email"
            )
            SocialTextFieldComponent(
                text = uiState.userPassword,
                onValueChange = {
                    onInteraction(RegisterInteraction.OnUserPasswordChanger(it))
                },
                labelText = "Password"
            )
            Spacer(modifier = modifier.height(dp40))
            AuthComponentBtn(
                btnText = "Sign Up",
                onClick = {
                    onInteraction(RegisterInteraction.OnRegisterButtonClick)
                    callBackInSuccessMainScreen()
                })
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
//    RegisterScreen {}
}