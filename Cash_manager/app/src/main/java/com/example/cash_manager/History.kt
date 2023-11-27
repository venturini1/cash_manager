package com.example.cash_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cash_manager.ui.theme.Cash_managerTheme

class History : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                HistoryPage()
            }
        }
    }
}

@Composable
fun HistoryPage(){
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
}

@Preview(showBackground = true)
@Composable
fun HistoryPagePreview() {
    Cash_managerTheme() {
        HistoryPage()
    }
}

