import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.KeyboardDismissedListener
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndexAdminTextField() {
    val keyboardState = rememberKeyboardState()

    val textFieldValue = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier,
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Code Barre",
            fontWeight = FontWeight.SemiBold,
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { textFieldValue.value = it },
            onKeyboardDismissed = {
                val filteredText = textFieldValue.value.text.filter { char -> char.isDigit() }
                if (filteredText.length == textFieldValue.value.text.length) {
                    textFieldValue.value = TextFieldValue(filteredText)
                } else {
                    textFieldValue.value = TextFieldValue(filteredText.substring(0, filteredText.length - 1))
                }
            },
            placeholder = {
                Text(text = "0173291302718")
            }
        )
    }

    @Composable
    fun KeyboardDismissedListener() {
        if (keyboardState.isKeyboardVisible) {
            // Do something when the keyboard is visible
        } else {
            // Filter the text after the keyboard is dismissed
            // TODO: Filter the text here
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndexAdminTextFieldPreview() {
    IndexAdminTextField()
}
