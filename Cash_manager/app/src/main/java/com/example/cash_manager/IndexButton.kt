package com.example.cash_manager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IndexButton(
    text: String,
    text1: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
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
            modifier = modifier.height(60.dp)
                .width(150.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF728963),
                contentColor = Color.White,
            ),
            onClick = { /*TODO*/ }
        )
        {
            Text(text = text1)
        }
    }
}
@Composable
fun BottomButton(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = Color(0xFF728963),
                //shape = RoundedCornerShape(30.dp) // ajustez le rayon selon vos besoins
            )
            .padding(vertical = 8.dp) // Ajustez la valeur selon vos besoins
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.scan_svgrepo_com),
                contentDescription = stringResource(id = R.string.ctn_desc_use_scan),
                tint = Color.Unspecified
            )
        }

        // Divider vertical entre les boutons
        Divider(
            color = Color.White,
            modifier = Modifier
                .height(45.dp)
                .width(1.dp)
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.basket_svgrepo_com),
                contentDescription = stringResource(id = R.string.ctn_desc_see_ticket),
                tint = Color.Unspecified
            )
        }

        // Divider vertical entre les boutons
        Divider(
            color = Color.White,
            modifier = Modifier
                .height(45.dp)
                .width(1.dp)
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.user_circle_svgrepo_com),
                contentDescription = stringResource(id = R.string.ctn_desc_edit_your_information),
                tint = Color.Unspecified
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomButtonPreview(){
    BottomButton(
        modifier = Modifier.fillMaxWidth(),
    )
}


@Preview(showBackground = true)
@Composable
fun IndexButtonPreview() {
    IndexButton(
        text= "Cancel",
        text1= "Add",
    )
}
