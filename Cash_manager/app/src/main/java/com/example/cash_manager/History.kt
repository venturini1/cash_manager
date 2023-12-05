package com.example.cash_manager

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cash_manager.ui.theme.Cash_managerTheme

class History : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                HistoryPage(navController = navController)
            }
        }
    }
}

@Composable
fun HistoryPage(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Text(
            text = "History",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(40.dp))
        HistoryListe()

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
fun HistoryPagePreview() {
    val navController = rememberNavController()
    Cash_managerTheme() {
        HistoryPage(navController = navController)
    }
}

