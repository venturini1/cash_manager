package com.example.cash_manager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun LoginButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    navController: NavController
){
    Button(
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF728963),
        ),
        onClick = {
            onClick()// Appel de la fonction lambda passée en paramètre
            // Naviguer vers la page d'index lorsque le bouton de connexion est cliqué
            navController.navigate("scan")
        }
    )
    {
        Text(text = text)
    }
}

@Composable
fun LoginOutlineButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
        ),
        onClick = { /*TODO*/ }) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
fun LoginThirdPartyRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_facebook),
                contentDescription = stringResource(id = R.string.ctn_desc_login_with_facebook),
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_google),
                contentDescription = stringResource(id = R.string.ctn_desc_login_with_google),
                tint = Color.Unspecified
            )

        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_apple),
                contentDescription = stringResource(id = R.string.ctn_desc_login_with_apple),
                tint = Color.Unspecified
            )

        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginThirdPartyRowPreview(){
    LoginThirdPartyRow(
        modifier = Modifier.fillMaxWidth(),
    )
}


@Preview(showBackground = true)
@Composable
fun LoginOutlineButtonPreview(){
    LoginOutlineButton(
        text = "Forget password ?"
    )
}

@Preview(showBackground = true)
@Composable
fun LoginButtonPreview() {
    // Assurez-vous d'avoir un NavController disponible dans votre portée
    val navController = rememberNavController()

    LoginButton(
        text = "Login",
        onClick = {
            // Actions à effectuer lors du clic sur le bouton (si nécessaire)
        },
        navController = navController // Passez le NavController ici
    )
}
