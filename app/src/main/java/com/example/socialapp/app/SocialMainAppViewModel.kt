package com.example.socialapp.app

import androidx.lifecycle.ViewModel
import com.example.socialapp.presentation.manager.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SocialMainAppViewModel @Inject constructor(
    navigationManager: NavigationManager
) : ViewModel() {
    val destinationFlow = navigationManager.observeDestinationFlow()
}