package com.example.cash_manager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IndexAdminButton(
    text: String,
    text1: String,
    text2: String,
    text3: String,
    modifier: Modifier = Modifier
){
    Column {


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
                Text(text = text1)
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
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
                Text(text = text2)
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
                onClick = { /*TODO*/ }
            )
            {
                Text(text = text3)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndexAdminButtonPreview() {
    IndexAdminButton(
        text= "Cancel",
        text1= "Save",
        text2= "Delete",
        text3= "Add",
    )
}
