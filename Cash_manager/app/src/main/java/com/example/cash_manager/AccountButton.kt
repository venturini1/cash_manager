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

@Composable
fun DisconnectButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .padding(0.dp)
            .height(40.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(255, 55, 55),
        ),
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(0.dp) // Ajustez le padding selon vos préférences
                //.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisconnectButtonPreview() {
    DisconnectButton(
        text = "Disconnect",
    )
}
