package view

import androidx.compose.desktop.Window
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import ui.DesktopTheme
import navigation.NavHostComponent


/**
 * Where all magic starts ;)
 */
fun main() = Window(
    title = "Decompose Desktop Example"
) {
    DesktopTheme {
        rememberRootComponent(factory = ::NavHostComponent)
            .render()
    }
}
