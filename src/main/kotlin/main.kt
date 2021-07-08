import androidx.compose.desktop.Window
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object AppSettings {
    var darkMode by mutableStateOf<Boolean>(true)
}

fun main() = Window {
    val DarkColors = darkColors(primary = Color(245, 127, 127), secondary = Color.White)
    val LightColors = lightColors(primary = Color(222, 78, 78), secondary = Color.White)

    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme(colors = if (!AppSettings.darkMode) LightColors else DarkColors) {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)

        }
    }
}

fun App(content: (p: String) -> Unit) {
    println("hello console")
}