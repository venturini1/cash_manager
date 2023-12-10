package com.example.cash_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Product(val name: String, val price: String)

class IndexProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                ProductList()
            }
        }
    }
}

@Composable
fun ProductList() {
    val listOfProducts = listOf(
        Product(name = "Produit A", price = "19.99€"),
        Product(name = "Produit A", price = "19.99€"),
        Product(name = "Produit B", price = "29.99€"),
        Product(name = "Produit B", price = "29.99€"),
        Product(name = "Produit B", price = "29.99€"),
        Product(name = "Produit C", price = "9.99€"),
        Product(name = "Produit C", price = "9.99€"),
    )

    var productQuantities by remember { mutableStateOf(mutableMapOf<Product, Int>()) }

    for (product in listOfProducts) {
        // Update the quantity in the map
        productQuantities[product] = (productQuantities[product] ?: 0) + 1
    }

    Column {
        productQuantities.forEach { (product, quantity) ->
            ListProduct(
                key = product, // Use product as the key
                product = product,
                quantity = quantity,
                onQuantityUpdated = { updatedQuantity ->
                    productQuantities[product] = updatedQuantity
                }
            )
        }
    }
}

@Composable
fun ListProduct(product: Product, quantity: Int, onQuantityUpdated: (Int) -> Unit, key: Product) {
    var localQuantity by remember { mutableStateOf(quantity) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp)
            .background(Color.Gray, RoundedCornerShape(30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )

            Text(
                text = product.price,
                fontSize = 25.sp,
            )

            Box(
                modifier = Modifier
                    .clickable {
                        localQuantity++
                        onQuantityUpdated(localQuantity)
                    }
                    .padding(start = 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Qt: $localQuantity")
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        }
    }
}

@Preview
@Composable
fun ListProductPreview() {
    Surface {
        ProductList()
    }
}
