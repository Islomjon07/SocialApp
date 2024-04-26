package com.example.socialapp.presentation.authorization.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialapp.R
import com.example.socialapp.presentation.theme.PurpleBlack
import com.example.socialapp.presentation.theme.dp12
import com.example.socialapp.presentation.theme.dp40


@Composable
fun SignToolBarComponent(
    modifier: Modifier = Modifier,
    onIconClick: () -> Unit,
    text: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(PurpleBlack)
            .padding(start = 12.dp, top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(dp12)
    ) {
        IconButton(onClick = { onIconClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.left),
                contentDescription = null,
                tint = Color.White
            )
        }
        Spacer(modifier = modifier.height(dp40))

        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignToolBarComponentPreview() {
    SignToolBarComponent(
        text = "",
        onIconClick = {}
    )

}