package com.example.socialapp.presentation.nav.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.socialapp.presentation.authorization.nav.graph.AUTH_GRAPH_TAG
import com.example.socialapp.presentation.authorization.nav.graph.AuthNavGraph
import com.example.socialapp.presentation.authorization.nav.graph.MAIN_NAV_GRAPH
import com.example.socialapp.presentation.authorization.nav.graph.MainNavGraph

@Composable
fun SocialAppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_TAG,
    ) {
        composable(AUTH_GRAPH_TAG) {
            AuthNavGraph(callBackInSuccessMainScreen = {})
        }
        composable(MAIN_NAV_GRAPH) {
            MainNavGraph()
        }
    }
}