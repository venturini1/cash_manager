package com.example.cash_manager

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.ktor.client.*
import io.ktor.client.call.body

import kotlinx.coroutines.launch
import io.ktor.client.request.*
import io.ktor.client.statement.*

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class Scan : ComponentActivity() {

    //@Inject
    lateinit var barcodeScanner: BarcodeScanner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                val context = LocalContext.current
                 barcodeScanner = BarcodeScanner(context)
                val barcodeResults = barcodeScanner.barCodeResults.collectAsStateWithLifecycle()

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

@Serializable
data class Products(val id: Int, val name: String, val price: Double, val code: Int)

suspend fun get_data(): String {
    val client = HttpClient()

    val response: HttpResponse = client.get("http://13.36.64.65/api/products/12").body()
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
fun ScanPage(navController: NavController) {

    var responseData by remember { mutableStateOf<String?>(null) }
    val product = Products(id = 11, name = "Product 0", price = 53.0, code = 19)

    // Access fields of the Product instance
    val productId = product.id
    val productName = product.name
    val productPrice = product.price
    val productCode = product.code
    LaunchedEffect(true) {
        // Launch a coroutine to call the suspending function
        val productData = get_data()
        responseData = productData

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
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth(.85f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            onClick = {
                println("bonjour")
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

@Preview
@Composable
fun PreviewScanBarcode() {
    Cash_managerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            ScanBarcode({}, null)

   //         IndexAdminPage()
        }
    }
}
