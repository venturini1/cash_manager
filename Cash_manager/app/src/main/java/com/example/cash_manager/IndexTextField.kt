/*package com.example.cash_manager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Placeholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexTextField(
    name: String,
    price: Float,
    modifier : Modifier = Modifier,
   
){
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            text = name,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            text = price,
            fontWeight = FontWeight.SemiBold,
        )
        /*
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
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xF128128128),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            )
        )*/

    }
}

@Preview(showBackground = true)
@Composable
fun IndexTextFieldPreview(){
    IndexTextField(
        name = "Kinder",
        price = 6.9
    )
}*/