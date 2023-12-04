package com.example.cash_manager

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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cash_manager.ui.theme.Cash_managerTheme
import kotlinx.coroutines.launch
import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import android.provider.ContactsContract.CommonDataKinds.Identity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity



class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            onTapClient = Identity.getSignInClient(applicationContext)

        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Cash_managerTheme {
             //   val context = LocalContext.current
               // val barcodeScanner = BarcodeScanner(context)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                   // color = MaterialTheme.colors.background
                    color = Color.White
                ) {
                    println("testere")
                    val navController = rememberNavController()
                    //GreetingPreview()
                    NavHost(navController = navController, startDestination = "sign_in") {
                        composable("sign_in") {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if(googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate("profile")
                                }
                            }
                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = {result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignResult(signInResult)
                                        }

                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in ok",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    navController.navigate("profile")
                                    viewModel.resetState()
                                }
                            }

                            SignInScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                }
                            )
                        }
                        composable(route = "profile") {
                            ProfileScreen(
                                userData = googleAuthUiClient.getSignedInUser(),
                                onSignout = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        navController.popBackStack()
                                    }
                                }
                            )
                        }
                    }
                  //  LoginPage()
                }
            }
        }
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

@Composable
fun LoginPage(

){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            Spacer(modifier = Modifier.size(40.dp))
        Text(
            text = "Login",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
            Spacer(modifier = Modifier.size(4.dp))
        Text(
           text = "Login to continue the app",
           fontSize = 12.sp,
           fontWeight = FontWeight.Bold,
        )
            Spacer(modifier = Modifier.size(60.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "User Name/Email",
            placeholder = "Enter your user name or your email",
        )
            Spacer(modifier = Modifier.size(30.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            placeholder = "Enter your password",
            isPassword = true,
        )
        LoginOutlineButton(
            modifier = Modifier.align(End),
            text = "Forget Password"
        )
            Spacer(modifier = Modifier.size(30.dp))
        LoginButton(
            modifier = Modifier.fillMaxWidth(),
            text= "Login"
        )
            Spacer(modifier = Modifier.size(30.dp))
        LoginDivider(
            modifier = Modifier.fillMaxWidth(),
            informationText = "Or Login With"
        )
            Spacer(modifier = Modifier.size(30.dp))
        LoginThirdPartyRow(
            modifier = Modifier.fillMaxWidth(),
        )
            Spacer(modifier = Modifier.size(30.dp))
        LoginClickableText(
            modifier = Modifier.align(CenterHorizontally),
            text = buildCreateAccountAnnotatedString()
        )
    }
}
@Composable
fun buildCreateAccountAnnotatedString() = buildAnnotatedString {
        append("Don't have an account ? ")
        withStyle(style = SpanStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue)
        ){
            append("Create") }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cash_managerTheme {
        LoginPage()
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