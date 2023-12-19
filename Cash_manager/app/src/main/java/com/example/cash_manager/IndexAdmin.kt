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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cash_manager.ui.theme.Cash_managerTheme
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction0
import androidx.navigation.compose.rememberNavController as rememberNavController1

var save1: KSuspendFunction0<Unit>? = null;
var save2: String? = null;

class IndexAdmin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController1()
                IndexAdminPage(navController = navController )
            }
        }
    }
}


@Composable
fun IndexAdminPage(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
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
    BottomButton(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
        navController = navController
    )
}
}

//@Composable
//fun IndexPageAdminPreview() {
//    val navController = rememberNavController1()
//    Cash_managerTheme() {
//        IndexAdminPage(navController = navController)
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = Color.White
//        ) {
//            ScanBarcode({
//                save1
//            }, save2)
//    //        IndexAdminPage()
//        }
//    }
//}


//@Preview
//@Composable
//fun PreviewScanBarcode() {
//    Cash_managerTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = Color.White
//        ) {
//
//            ScanBarcode({
//                save1
//            }, save2)
//            IndexAdminPage()
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun IndexPageAdminPreview() {
    val navController = rememberNavController()
    Cash_managerTheme() {
        IndexAdminPage(navController = navController)
    }
}



