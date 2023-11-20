package com.example.cash_manager

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginDivider(
    modifier : Modifier = Modifier,
    informationText: String = "",
    ){
    val showInformationText by remember { derivedStateOf { informationText.isNotEmpty() } }
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Divider(
            modifier = Modifier.weight(1f),
            color = Color(0xFFF5F5F5)
        )
        if (showInformationText) {
            Text(
                modifier = Modifier.weight(1f),
                text = informationText,
                textAlign = TextAlign.Center,
            )
        }
        Divider(
            modifier = Modifier.weight(1f),
            color = Color(0xFFF5F5F5)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginDividerPreview(){
    LoginDivider(
        modifier = Modifier.fillMaxWidth(),
        informationText = "Or Login with"
    )
}