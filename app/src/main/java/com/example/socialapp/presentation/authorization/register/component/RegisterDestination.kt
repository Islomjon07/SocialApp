package com.example.socialapp.presentation.authorization.register.component

import com.example.socialapp.presentation.nav.graph.Destination

object RegisterDestination : Destination {
    override val route: String
        get() = "register_destination"

    override val routeWithArgs: String
        get() = "register_with_args"
}