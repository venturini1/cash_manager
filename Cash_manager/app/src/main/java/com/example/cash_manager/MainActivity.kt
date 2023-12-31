package com.example.cash_manager

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import com.example.cash_manager.ui.theme.Cash_managerTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                MainContent(this)
            }
        }
    }
}

@Composable
fun MainContent(context: Context) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController = navController) }
        composable("signup") { SignUpPage(navController = navController) }
        composable(
            "index/{responseData}",
            arguments = listOf(navArgument("responseData") { type = NavType.StringType })
        ) { backStackEntry ->
            val responseData = backStackEntry.arguments?.getString("responseData")
            IndexPage(navController, responseData)
        }
        composable("history") { HistoryPage(navController = navController) }
        composable("account") { AccountPage(navController = navController) }
        composable("scan") {
            val barcodeScanner = BarcodeScanner(context) // Create an instance of the BarcodeScanner
            ScanPage(navController = navController, barcodeScanner = barcodeScanner)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainContentPreview() {
//    Cash_managerTheme {
//        MainContent()
//    }
//}