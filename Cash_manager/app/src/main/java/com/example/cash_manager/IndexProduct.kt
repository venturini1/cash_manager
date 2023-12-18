import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
import kotlinx.serialization.Serializable

@Serializable
data class Product(val name: String, val price: String, var quantity: Int)


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
    val setOfProducts = mutableSetOf(
        Product(name = "Produit A", price = "1.99€", quantity = 1),
        Product(name = "Produit B", price = "19.99€", quantity = 1),
        Product(name = "Produit B", price = "19.99€", quantity = 1),
        Product(name = "Produit D", price = "19.99€", quantity = 1),
        Product(name = "Produit E", price = "9.99€", quantity = 1),
        Product(name = "Produit F", price = "18.99€", quantity = 1),
        Product(name = "Produit G", price = "19.99€", quantity = 1),
        Product(name = "Produit H", price = "19.99€", quantity = 1),
        Product(name = "Produit I", price = "19.99€", quantity = 1),
        Product(name = "Produit J", price = "19.99€", quantity = 1),
        // ... Ajoutez d'autres produits ici
    )

    var productList by remember { mutableStateOf(setOfProducts.toList()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .verticalScroll(rememberScrollState())
    ) {
        productList.forEachIndexed { index, product ->
            ListProduct(
                product = product,
                onQuantityUpdated = { updatedQuantity ->
                    val updatedProducts = productList.toMutableList()
                    val existingProductIndex = updatedProducts.indexOfFirst { it.name == product.name }
                    if (existingProductIndex != -1) {
                        updatedProducts[existingProductIndex] = product.copy(quantity = updatedQuantity)
                        productList = updatedProducts
                    }
                },
                onDeleteProduct = {
                    val updatedProducts = productList.toMutableList()
                    val existingProductIndex = updatedProducts.indexOfFirst { it.name == product.name }
                    if (existingProductIndex != -1) {
                        updatedProducts.removeAt(existingProductIndex)
                        productList = updatedProducts
                    }
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Composable
fun ListProduct(
    product: Product,
    onQuantityUpdated: (Int) -> Unit,
    onDeleteProduct: () -> Unit
) {
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
            horizontalArrangement = Arrangement.SpaceBetween
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
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Text("Qt: ${product.quantity}")
                IconButton(
                    onClick = {
                        onQuantityUpdated(product.quantity - 1)
                    },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }

                IconButton(
                    onClick = onDeleteProduct,
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
