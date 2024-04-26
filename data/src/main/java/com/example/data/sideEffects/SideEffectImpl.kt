package com.example.data.sideEffects

import android.content.Context
import android.widget.Toast
import com.example.domain.sideEffects.SideEffect
import dagger.hilt.android.qualifiers.ApplicationContext

class SideEffectImpl(
   @ApplicationContext private val context: Context
): SideEffect {
    override fun makeToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}