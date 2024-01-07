package com.example.cash_manager

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginClickableText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    navController: NavController
){
    ClickableText(
        modifier = modifier,
        text = text ,
        onClick = {
            onClick()
            navController.navigate("Signup")
        })
}
/*
@Preview(showBackground = true)
@Composable
fun LoginClickableTextPreview(){
    val annotatedString = buildAnnotatedString {
        append("Don't have an account ? ")
        withStyle(style = SpanStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue)){
            append("Create")
        }
    }
    LoginClickableText(
        text = annotatedString,
        modifier = Modifier.fillMaxWidth(),
    )
}*/