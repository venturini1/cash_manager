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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cash_manager.ui.theme.Cash_managerTheme
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction0

var save1: KSuspendFunction0<Unit>? = null;
var save2: String? = null;

class IndexAdmin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                val context = LocalContext.current
                val barcodeScanner = BarcodeScanner(context)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue
                ) {
                    // A surface container using the 'background' color from the theme
                    //IndexAdminPage()
                    val barcodeResults =
                        barcodeScanner.barCodeResults.collectAsStateWithLifecycle()
                    save1 = barcodeScanner::startScan
                    save2 = barcodeResults.value
                    ScanBarcode(
                        barcodeScanner::startScan,
                        barcodeResults.value

                    )

                }
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

@Composable
private fun ScanBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
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
            color = Color.White
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

            ScanBarcode({
                save1
            }, save2)
            IndexAdminPage()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun IndexPageAdminPreview() {
//    Cash_managerTheme() {
//        IndexAdminPage()
//    }
//}



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