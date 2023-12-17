package com.example.cash_manager

import RectangleWithText
import RectangleWithTotal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cash_manager.ui.theme.Cash_managerTheme
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.volley.toolbox.HttpResponse
import io.ktor.client.*

import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import kotlinx.coroutines.launch
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

import kotlinx.coroutines.runBlocking


class Scan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                val context = LocalContext.current
                val barcodeScanner = BarcodeScanner(context)
                val barcodeResults = barcodeScanner.barCodeResults.collectAsStateWithLifecycle()

                // Launch a coroutine scope
                val scope = rememberCoroutineScope()

                // Call the ScanBarcode composable function
                ScanBarcode(
                    barcodeScanner::startScan,
                    barcodeResults.value
                )

                val navController = rememberNavController()
                ScanPage(navController = navController)
            }
        }
    }
}

suspend fun get_data(): String {
    val client = HttpClient(CIO)

    val response: io.ktor.client.statement.HttpResponse = client.get("https://valorant-api.com/v1/agents")
    val Data = response.bodyAsText()
    println(response.status)
    client.close()
    return Data
}

@Composable
fun ScanPage(navController: NavController) {

    var responseData by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(true) {
        // Launch a coroutine to call the suspending function
        val data = get_data()
        responseData = data

    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BottomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            navController = navController
        )

        ScanBarcode({
            save1
        }, save2)
        Text("Response Data: $responseData")

//        CodeCard(
//            jsonStr = "{\n" +
//                    "  id: 101,\n" +
//                    "  title: 'foo',\n" +
//                    "  body: 'bar',\n" +
//                    "  userId: 1\n" +
//                    "}"
//        )

        // Call the ScanBarcode composable function

    }
}

@Preview(showBackground = true)
@Composable
fun ScanPagePreview() {
    val navController = rememberNavController()
    Cash_managerTheme() {
        ScanPage(navController = navController)
    }
}

@Composable
private fun ScanBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth(.85f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            onClick = {
                scope.launch {
                    onScanBarcode()
                }
            }) {
            Text(
                text = "Scan Barcode",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
                //style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = barcodeValue ?: "0000000000",
            style = MaterialTheme.typography.displayMedium,
            color = Color.Black
        )
    }
}

@Composable
fun CodeCard(jsonStr: String) {
    val scrollState = rememberScrollState()

    Card(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(
            state = scrollState,
            enabled = true
        )
        .padding(all = 8.dp),
    ) {
        Text(
            modifier = Modifier.padding(start = 12.dp, top=12.dp),
            text = "response: ",
            style = MaterialTheme.typography.labelSmall,
            fontFamily = FontFamily.Monospace
        )
        Text(
            modifier = Modifier.padding(all = 12.dp),
            text = jsonStr,
            fontFamily = FontFamily.Monospace
        )
    }

}

@Preview
@Composable
fun PreviewScanBarcode() {
    Cash_managerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            CodeCard("")
            ScanBarcode({
                save1
            }, save2)
   //         IndexAdminPage()
        }
    }
}
