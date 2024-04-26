package com.example.socialapp.presentation.authorization.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.socialapp.presentation.theme.MedBlue
import com.example.socialapp.presentation.theme.dp24
import com.example.socialapp.presentation.theme.dp48
import com.example.socialapp.presentation.theme.sp18
import com.example.socialapp.presentation.theme.sp20

@Composable
fun AuthComponentBtn(
    btnText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MedBlue),
        shape = RoundedCornerShape(dp24),
        modifier = modifier
            .fillMaxWidth()
            .height(dp48)
    ) {
        Text(
            text = btnText,
            color = Color.White,
            fontSize = sp18
        )
    }
}