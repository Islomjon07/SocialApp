package com.example.socialapp.presentation.authorization.nav.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialapp.presentation.screens.main.screen.MainScreen

const val MAIN_SCREEN = "MainScreen"
const val MAIN_NAV_GRAPH = "MainNavGraph"

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN,
    ) {
        composable(MAIN_SCREEN) {
            MainScreen()
        }
    }
}