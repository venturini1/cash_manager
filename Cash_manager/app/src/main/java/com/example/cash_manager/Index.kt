package com.example.cash_manager

import RectangleWithText
import RectangleWithTotal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cash_manager.ui.theme.Cash_managerTheme
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


class Index : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                IndexPage(navController = navController)
            }
        }
    }
}
@Composable
fun IndexPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            RectangleWithText(
                "Produit A",
                "$19.99",
            )

            IndexButton(
                text = "Cancel",
                text1 = "Add",
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
        }




                PayButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 70.dp),
                    //horizontalArrangement = Arrangement.SpaceEvenly,
                    text= "Pay",
                    name="Total",
                    price= "19.99€"
                )


            BottomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                navController = navController
            )

    }
}

@Preview(showBackground = true)
@Composable
fun IndexPagePreview() {
    val navController = rememberNavController()
    Cash_managerTheme() {
        IndexPage(navController = navController)
    }
}

