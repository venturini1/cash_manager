import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cash_manager.LoginPage

@Composable
fun DisconnectButton(
    text: String,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Button(
        modifier = modifier
            .padding(0.dp)
            .height(40.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(255, 55, 55),
        ),
        onClick = { Log.d("DisconnectButton", "Button clicked")
            navController.navigate("login") }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(0.dp)
        )
    }
}


@Composable
fun HistoryButton(
    text: String,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Button(
        modifier = modifier
            .padding(0.dp)
            .height(40.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(78, 136, 81, 255),
        ),
        onClick = { Log.d("DisconnectButton", "Button clicked")
            navController.navigate("history") }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(0.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HistoryButtonPreview() {
    val navController = rememberNavController()
    HistoryButton(
        text = "History",
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun DisconnectButtonPreview() {
    val navController = rememberNavController()
    DisconnectButton(
        text = "Disconnect",
        navController = navController
    )
}
