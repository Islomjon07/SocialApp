package com.example.socialapp.presentation.authorization.nav.graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialapp.presentation.authorization.login.component.LoginDestination
import com.example.socialapp.presentation.authorization.login.LoginScreen
import com.example.socialapp.presentation.authorization.login.LoginViewModel
import com.example.socialapp.presentation.authorization.register.component.RegisterDestination
import com.example.socialapp.presentation.authorization.register.RegisterScreen
import com.example.socialapp.presentation.authorization.register.RegisterViewModel


const val AUTH_GRAPH_TAG = "AuthNavGraph"

@Composable
fun AuthNavGraph(
    callBackInSuccessMainScreen: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RegisterDestination.route
    ) {
        composable(LoginDestination.route) {
            val viewModel: LoginViewModel = hiltViewModel()
            LoginScreen(
                onInteraction = viewModel::onInteraction,
                uiStateFlow = viewModel.uiState,
            )
        }
        composable(RegisterDestination.route) {
            val viewModel: RegisterViewModel = hiltViewModel()
            RegisterScreen(
                onInteraction = viewModel::onInteraction,
                uiStateFlow = viewModel.uiState,
                callBackInSuccessMainScreen = callBackInSuccessMainScreen
            )
        }
    }
}