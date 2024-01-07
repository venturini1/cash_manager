package com.example.cash_manager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexAdminTextField(
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
) {

    var textFieldValue by remember { mutableStateOf("") }
    var isHided by remember { mutableStateOf(true) }

    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = label,
            fontWeight = FontWeight.SemiBold,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
            },
            placeholder = {
                Text(text = placeholder)
            },
            trailingIcon = {

            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xF128128128),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminRectangleWithText() {
    var name by remember { mutableStateOf("Name Product") }
    var price by remember { mutableStateOf("Price") }
    var codeBarre by remember { mutableStateOf("Code Barre") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .background(Color(0xF128128128), RoundedCornerShape(30.dp)) // Coins arrondis
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Partie haute : Nom
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 0.dp),
                value = name,
                onValueChange = { newName -> name = newName },
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp))
            // Partie centrale : Prix
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = price,
                onValueChange = { newPrice -> price = newPrice },
                textStyle = TextStyle(
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp))
            // Partie basse : Code Barre
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = codeBarre,
                onValueChange = { newCodeBarre -> codeBarre = newCodeBarre },
                textStyle = TextStyle(
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
    }
}

@Preview
@Composable
fun AdminRectangleWithTextPreview() {
    Surface {
        AdminRectangleWithText()
    }
}

@Preview(showBackground = true)
@Composable
fun IndexAdminTextFieldPreview() {
    IndexAdminTextField(
        label = "Code Barre",
        placeholder = "0173291302718",
    )
}
