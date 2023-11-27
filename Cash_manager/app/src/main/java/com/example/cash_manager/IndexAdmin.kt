package com.example.cash_manager

import RectangleWithText
import RectangleWithTotal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cash_manager.ui.theme.Cash_managerTheme

class IndexAdmin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                IndexAdminPage()
            }
        }
    }
}

@Composable
fun IndexAdminPage(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    )
    {
        RectangleWithText(
            "Produit A",
            "$19.99",
        )
        IndexAdminButton(
            text= "Cancel",
            text1= "Save",
            text2= "Delete",
            text3= "Add",
        )

    }
}

@Preview(showBackground = true)
@Composable
fun IndexPageAdminPreview() {
    Cash_managerTheme() {
        IndexAdminPage()
    }
}



/*
@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun GreetingPreview() {
    Cash_managerTheme {
        LoginPage()
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun GreetingPreviewDark() {
    Cash_managerTheme(darkTheme = true) {
        LoginPage()
    }
}*/