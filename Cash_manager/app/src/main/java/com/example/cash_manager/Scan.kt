package com.example.cash_manager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cash_manager.ui.theme.Cash_managerTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.api.Context
import io.ktor.client.*
import io.ktor.client.call.body

import kotlinx.coroutines.launch
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.math.BigInteger
import javax.inject.Inject


class Scan : ComponentActivity() {

    lateinit var barcodeScanner: BarcodeScanner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        barcodeScanner = BarcodeScanner(this)
        setContent {
            Cash_managerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    ScanPage(navController = navController, barcodeScanner)

                    }
                }
//                val context = LocalContext.current

        }
    }
}


// Create a DataStore instance
//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//
//object DataStoreKeys {
//    val RESPONSE_DATA = stringPreferencesKey("response_data")
//}
//
//// Function to save responseData to DataStore
//suspend fun saveResponseDataToDataStore(context: Context, responseData: String) {
//    context.dataStore.edit { preferences ->
//        preferences[DataStoreKeys.RESPONSE_DATA] = responseData
//    }
//}
//
//// Function to get responseData from DataStore
//fun getResponseDataFromDataStore(context: Context): Flow<String?> {
//    return context.dataStore.data.map { preferences ->
//        preferences[DataStoreKeys.RESPONSE_DATA]
//    }
//}
suspend fun get_data(bigIntParameter: BigInteger): String {
    val client = HttpClient()

    val response: HttpResponse = client.get("http://13.36.64.65/api/products/code/${bigIntParameter}").body()
    val datar = response.bodyAsText()
    //1val product = response.body<Products>()

    val res = Json.encodeToString(datar)
    val result = res.split("\\", ",")
    val result1 = result[6].drop(1)
    // Access the "name" field from the data class

    // Print and return the name
    println(res[5])
    println(res)
    println(result)
    println(result[6])
    //println(result1[5])
    println(datar)
    client.close()
    return result1
}

@Composable
fun ScanPage(navController: NavController, barcodeScanner: BarcodeScanner) {

    var responseData by remember { mutableStateOf<String?>(null) }
    var responsesData by remember { mutableStateOf<BigInteger?>(null) }

    LaunchedEffect(true) {
        // Launch a coroutine to call the suspending function


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
            // ScanBarcode({}, null)
    }
    var valueScanned by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp)) {
        Text(text = valueScanned, modifier = Modifier.align(Alignment.Center))

        Button(

            onClick = {
                scope.launch {
                    valueScanned = barcodeScanner.startScan().toString()
                    responsesData = valueScanned.toBigInteger()
                    val productData = get_data(responsesData!!)
                    responseData = productData
                    val route = "index/$responseData"
                    navController.navigate(route)
                   // navController.navigate("index/{responseData}")

                }

            },

            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Scan Barcode",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
                //style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
        Text("Response Data: $responseData")

        Spacer(modifier = Modifier.height(20.dp))

//        Text(
//            text = valueScanned ?: "0000000000",
//            style = MaterialTheme.typography.displayMedium,
//            color = Color.Black
//        )

    }
}

//@Preview(showBackground = true)
//@Composable
//fun ScanPagePreview() {
//    val navController = rememberNavController()
//    Cash_managerTheme() {
//        ScanPage(navController = navController)
//    }
//}
//
//@SuppressLint("CoroutineCreationDuringComposition")
//@Composable
// fun ScanBarcode(
//    onScanBarcode: suspend () -> Unit,
//    barcodeValue: String?
//) {
//    var valuescanned by remember {
//        mutableStateOf("")
//    }
//    val scope = rememberCoroutineScope()
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        scope.launch {
//            onScanBarcode()
//        }
//        Button(
//            modifier = Modifier
//                .fillMaxWidth(.85f),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color.Red
//            ),
//            onClick = {
//                println("bonjour")
//                scope.launch {
//                    onScanBarcode()
//                }
//            }) {
//            Text(
//                text = "Scan Barcode",
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.displayMedium,
//                color = Color.White
//                //style = TextStyle(fontWeight = FontWeight.Bold)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(
//            text = barcodeValue ?: "0000000000",
//            style = MaterialTheme.typography.displayMedium,
//            color = Color.Black
//        )
//    }
//}
//
//@Preview
//@Composable
//fun PreviewScanBarcode() {
//    Cash_managerTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = Color.White
//        ) {
//            ScanBarcode({}, null)
//
//   //         IndexAdminPage()
//        }
//    }
//}
