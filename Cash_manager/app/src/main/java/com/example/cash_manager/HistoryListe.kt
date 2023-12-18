@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cash_manager

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun get_dataa(): String {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryListe(
    modifier: Modifier = Modifier
) {
    var isListVisible1 by remember { mutableStateOf(false) }
    var isListVisible2 by remember { mutableStateOf(false) }
    var isListVisible3 by remember { mutableStateOf(false) }
    var responseData by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(true) {
        // Launch a coroutine to call the suspending function
        val productData = get_data()
        responseData = productData

    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        // Add the first list
        item {
            Text(
                text = "Liste de course 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(30.dp))
                    .padding(10.dp)
                    //.background(Color(0xF128128128), RoundedCornerShape(30.dp))
                    .clickable {
                    // Toggle the visibility of the first list when clicked
                    isListVisible1 = !isListVisible1
                },


            )
        }

        // Show the first list if it is visible
        if (isListVisible1) {
            // Add items for the first list
            item {
                Text(text = "Lait")
            }
            item {
                Text(text = "Café")
            }
        }

        // Add the second list
        item {
            Text(
                text = "Liste de course 2",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(30.dp))
                    .padding(10.dp)
                    .clickable {
                    // Toggle the visibility of the second list when clicked
                    isListVisible2 = !isListVisible2
                }
            )
        }

        // Show the second list if it is visible
        if (isListVisible2) {
            // Add items for the second list
            item {
                responseData?.let { Text(text = it) }
            }
            item {
                Text(text = "Pomme 1")
            }
            item {
                Text(text = "Pomme 2")
            }
            item {
                Text(text = "Pomme 3")
            }
            item {
                Text(text = "Pomme 4")
            }
        }

        // Add the second list
        item {
            Text(
                text = "Liste de course 3",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(30.dp))
                    .padding(10.dp)
                    .clickable {
                    // Toggle the visibility of the second list when clicked
                    isListVisible3 = !isListVisible3
                }
            )
        }

        // Show the second list if it is visible
        if (isListVisible3) {
            // Add items for the second list
            item {
                Text(text = "Yaourt")
            }
            item {
                Text(text = "Carrote")
            }
            item {
                Text(text = "PommeDeTerre 2")
            }
            item {
                Text(text = "Banane 3")
            }
            item {
                Text(text = "Kiwi 4")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryListePreview() {
    HistoryListe()
}
