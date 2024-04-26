package com.example.socialapp.presentation.authorization.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialapp.R
import com.example.socialapp.presentation.authorization.components.AuthComponentBtn
import com.example.socialapp.presentation.authorization.components.SignToolBarComponent
import com.example.socialapp.presentation.authorization.components.SocialTextFieldComponent
import com.example.socialapp.presentation.authorization.login.component.LoginInteractions
import com.example.socialapp.presentation.authorization.login.component.LoginScreenUiState
import com.example.socialapp.presentation.theme.MedBlue
import com.example.socialapp.presentation.theme.dp12
import com.example.socialapp.presentation.theme.dp14
import com.example.socialapp.presentation.theme.dp20
import com.example.socialapp.presentation.theme.dp40
import com.example.socialapp.presentation.theme.dp8
import com.example.socialapp.presentation.theme.sp12
import com.example.socialapp.presentation.theme.sp16
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onInteraction: (LoginInteractions) -> Unit,
    uiStateFlow: StateFlow<LoginScreenUiState>,
) {
    val uiState: LoginScreenUiState = uiStateFlow.collectAsState().value
    var onValueChange by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(dp20)
    ) {
        Column {
            SignToolBarComponent(
                onIconClick = { },
                text = stringResource(R.string.login),
            )
            Spacer(modifier = modifier.height(dp20))
            SocialTextFieldComponent(
                text = uiState.userName, onValueChange = {
                    onInteraction(LoginInteractions.OnUserNameChanged(it))
                }, labelText = stringResource(R.string.name)
            )
            SocialTextFieldComponent(
                text = uiState.userPassword, onValueChange = {
                    onInteraction(LoginInteractions.OnUserPasswordChanged(it))
                }, labelText = stringResource(R.string.password)
            )
            Spacer(modifier = modifier.height(dp14))
            Row(modifier = modifier.fillMaxWidth()) {
                Checkbox(
                    checked = onValueChange,
                    onCheckedChange = {
                        onValueChange = !onValueChange
                    },
                    colors = CheckboxDefaults.colors(
                        MedBlue
                    ),
                )
                Text(modifier = modifier
                    .padding(top = dp8)
                    .fillMaxWidth(),
                    fontSize = sp12,
                    lineHeight = sp16,
                    maxLines = 2,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                            append("Я согласен с ")
                        }
                        withStyle(style = SpanStyle(color = MedBlue)) {
                            append("Social App ")
                        }
                        withStyle(style = SpanStyle(color = Color.Gray)) {
                            append("Условиями предоставления услуг и конфиденциальностью")
                        }
                    })
            }
            Spacer(modifier = modifier.height(dp40))
            AuthComponentBtn(
                btnText = stringResource(R.string.login_sign_up),
                onClick = {
                    onInteraction(LoginInteractions.OnLoginButtonClickEvent)
                },
            )

            Spacer(modifier = modifier.height(dp14))
            Text(modifier = modifier
                .padding(horizontal = dp12)
                .clickable(onClick = { }),
                fontSize = sp12,
                lineHeight = sp16,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                        append("У вас нет учетной записи? ")
                    }
                    withStyle(
                        style = SpanStyle(color = MedBlue),
                    ) {
                        append("Авторизоваться")
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onInteraction = {},
        uiStateFlow = MutableStateFlow(LoginScreenUiState()),
    )
}
