package com.example.socialapp.presentation.manager

import kotlinx.coroutines.flow.Flow

interface NavigationManager {

    fun navigateTo(route: String,isBackStackClear:Boolean = false)

    fun observeDestinationFlow(): Flow<Pair<String,Boolean>>

}