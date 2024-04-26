package com.example.socialapp.presentation.authorization.login.component

import com.example.socialapp.presentation.nav.graph.Destination

object LoginDestination : Destination {
    override val route: String
        get() = "login_screen"
    override val routeWithArgs: String
        get() = "login_with_args"
}