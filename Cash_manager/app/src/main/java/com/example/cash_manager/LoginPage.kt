package com.example.cash_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cash_manager.ui.theme.Cash_managerTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                LoginPage(navController = navController)
            }
        }
    }
}


@Composable
fun LoginPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.size(40.dp))
        Text(
            text = "Login",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "Login to continue the app",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(60.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "User Name/Email",
            placeholder = "Enter your user name or your email",
        )
        Spacer(modifier = Modifier.size(30.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            placeholder = "Enter your password",
            isPassword = true,
        )
        LoginOutlineButton(
            modifier = Modifier.align(End),
            text = "Forget Password"
        )
        Spacer(modifier = Modifier.size(30.dp))
        LoginButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Login",
            onClick = {
                // Actions à effectuer lors du clic sur le bouton (si nécessaire)
            },
            navController = navController // Passez le NavController ici également
        )
        Spacer(modifier = Modifier.size(30.dp))
        LoginDivider(
            modifier = Modifier.fillMaxWidth(),
            informationText = "Or Login With"
        )
        Spacer(modifier = Modifier.size(30.dp))
        LoginThirdPartyRow(
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.size(30.dp))
        LoginClickableText(
            modifier = Modifier.align(CenterHorizontally),
            text = buildCreateAccountAnnotatedString()
        )
    }
}

@Composable
fun buildCreateAccountAnnotatedString() = buildAnnotatedString {
    append("Don't have an account ? ")
    withStyle(style = SpanStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Blue)
    ){
        append("Create") }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    Cash_managerTheme {
        LoginPage(navController = navController)
    }
}
