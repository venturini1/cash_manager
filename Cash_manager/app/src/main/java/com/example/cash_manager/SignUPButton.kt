package com.example.cash_manager


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cash_manager.SigningUp.SignUpViewModel
import kotlinx.coroutines.launch

@Composable
fun SignUpButton(
    text: String,
    text1: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    navController: NavController
){

    val scope = rememberCoroutineScope()
    var email by rememberSaveable{ mutableStateOf("") }
    var password by rememberSaveable{ mutableStateOf("") }

    Row(
        modifier = modifier,
        ) {

        Button(

            modifier = modifier
                .height(60.dp)
                .width(150.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF728963),
                contentColor = Color.White,
            ),
            onClick = { /*TODO*/ }
        )
        {
            Text(text = text)
        }
        Spacer(modifier = Modifier.size(40.dp))
        Button(
            modifier = modifier
                .height(60.dp)
                .width(150.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF728963),
                contentColor = Color.White,
            ),
            onClick = {
                onClick()
                navController.navigate("scan")
//                scope.launch {
//                    viewModel.registerUser(email, password)
//                }
            }
        )
        {
            Text(text = text1)
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun SignUpButtonPreview() {
//    SignUpButton(
//        text= "Back",
//        text1= "Create",
//    )
//}
