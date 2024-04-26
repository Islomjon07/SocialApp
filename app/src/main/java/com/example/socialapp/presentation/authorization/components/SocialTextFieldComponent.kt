package com.example.socialapp.presentation.authorization.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialapp.presentation.theme.MedBlue
import com.example.socialapp.presentation.theme.TextFieldColor

@Composable
fun SocialTextFieldComponent(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    labelText: String
) {

    TextField(
        modifier = modifier
            .padding(top = 15.dp)
            .fillMaxWidth(),
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                color = TextFieldColor,
                fontWeight = FontWeight.Normal,
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = TextFieldColor,
            unfocusedIndicatorColor = TextFieldColor,
        ),
    )

}

@Preview
@Composable
fun SocialTextFieldComponentPreview() {
    SocialTextFieldComponent(
        text = "",
        onValueChange = {},
        labelText = ""
    )
}