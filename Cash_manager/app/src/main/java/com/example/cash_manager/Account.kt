package com.example.cash_manager


import DisconnectButton
import HistoryButton
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cash_manager.ui.theme.Cash_managerTheme

class Account : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                AccountPage(navController = navController)
            }
        }
    }
}

@Composable
fun AccountPage(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        DisconnectButton(
            modifier = Modifier.align(Alignment.End),
            text = "Disconnect",
            navController = navController
        )
        Text(
            text = "Account",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "Hello",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(5.dp))
        HistoryButton(
            modifier = Modifier.fillMaxWidth(),

            text = "History",
            navController = navController
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "User Name",
            placeholder = "Enter your user name",
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "User Email",
            placeholder = "Enter your user email",
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "New Password",
            placeholder = "Enter your password",
            isPassword = true,
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Confirm Password",
            placeholder = "Confirm Password",
            isPassword = true,
        )
        Spacer(modifier = Modifier.size(50.dp))
        SignUpButton(
            modifier = Modifier.align(CenterHorizontally),
            text= "Back",
            text1= "Save",
        )
    }
        BottomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            navController = navController
        )
    }

}


@Preview(showBackground = true)
@Composable
fun AccountPagePreview() {
    val navController = rememberNavController()
    Cash_managerTheme() {
        AccountPage(navController = navController)
    }
}


