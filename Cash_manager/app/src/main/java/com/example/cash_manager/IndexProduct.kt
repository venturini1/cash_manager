import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cash_manager.R

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
        Product(name = "Produit B", price = "19.99€"),
        Product(name = "Produit C", price = "29.99€"),
        Product(name = "Produit D", price = "29.99€"),
        Product(name = "Produit E", price = "29.99€"),
        Product(name = "Produit F", price = "9.99€"),
        Product(name = "Produit F", price = "9.99€"),
        Product(name = "Produit G", price = "9.99€"),
        Product(name = "Produit H", price = "9.99€"),
        Product(name = "Produit I", price = "9.99€"),
        Product(name = "Produit J", price = "9.99€"),
    )

    var productQuantities by remember { mutableStateOf(mutableMapOf<Product, Int>()) }

    for (product in listOfProducts) {
        // Update the quantity in the map
        productQuantities[product] = (productQuantities[product] ?: 0) + 1
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .verticalScroll(rememberScrollState())
            //.heightIn(min = 0.dp, max = 300.dp)
    ) {
        productQuantities.forEach { (product, quantity) ->
            ListProduct(
                key = product, // Use product as the key
                product = product,
                quantity = quantity,
                onQuantityUpdated = { updatedQuantity ->
                    productQuantities[product] = updatedQuantity
                }
            )
            Spacer(modifier = Modifier.height(5.dp)) // Spacer with fixed height
        }
    }
}

@Composable
fun ListProduct(
    product: Product,
    quantity: Int,
    onQuantityUpdated: (Int) -> Unit,
    key: Product
) {
    var localQuantity by remember { mutableStateOf(quantity) }

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp)
            .background(Color(0xF128128128), RoundedCornerShape(30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween // Align children at the start and end
        ) {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = product.price,
                fontSize = 25.sp,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text("Qt: $localQuantity")
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)

                IconButton(
                    onClick = {},
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.bin_svgrepo_com),
                        contentDescription = stringResource(id = R.string.ctn_desc_delete_product),
                        tint = Color.Unspecified
                    )
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
