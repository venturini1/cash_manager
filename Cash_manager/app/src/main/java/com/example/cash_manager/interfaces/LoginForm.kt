/*@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cash_manager.interfaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.cash_manager.ui.theme.Cash_managerTheme

@Composable
fun LoginForm(){
    Surface {
        Column {
            LoginField(
                value = "data",
                onChange = {}
            )
            /*PasswordField()
            LabeledCheckbox()
            Button(onClick = {})*/
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Login",
    placeholder: String = "Enter your login"

){
    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable{
        Icon(
            Icons.Default.Person,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
    }

    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        KeyboardOptions = KeyboardOptions( imeAction = ImeAction.Next) ,
        keyboardActions = KeyboardActions(
            onNext = {focusManager.moveFocus(FocusDirection.Down)}
        ),
        //placeholder = { Text(placeholder) },
        //label = { Text(label) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
        )
}



@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun LoginFormPreview() {
    Cash_managerTheme {
        LoginForm()
    }
}
@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun LoginFormPreviewDark() {
    Cash_managerTheme(darkTheme = true) {
        LoginForm()
    }
}*/