import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun RectangleWithText(name: String, price: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .background(Color(0xF128128128), RoundedCornerShape(30.dp)) // Coins arrondis
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Partie haute : Nom
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )

            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp))
            // Partie basse : Prix
            Text(
                text = price,
                fontSize = 25.sp,
            )
        }
    }
}

@Composable
fun RectangleWithTotal(name: String, price: String,modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp)
            .background(Color(0xF128128128), RoundedCornerShape(30.dp)) // Coins arrondis
            .padding(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Partie haute : Nom
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )

            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp))
            // Partie basse : Prix
            Text(
                text = price,
                fontSize = 25.sp,
            )
        }
    }
}

@Preview
@Composable
fun RectangleWithTotalPreview() {

    Surface {
        RectangleWithTotal("Total", "19.99€")
    }
}


@Preview
@Composable
fun RectangleWithTextPreview() {

        Surface {
            RectangleWithText("Produit A", "19.99€")

    }
}
