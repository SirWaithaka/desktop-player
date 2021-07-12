package ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import ui.Component


@Composable
fun GreetingScreen(
    greeting: String,
    onGoBackClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Greeting
        Text(
            text = greeting,
            fontSize = 40.sp
        )

        // Spacing between text and button
        Spacer(modifier = Modifier.height(30.dp))

        // Go back button
        Button(onClick = onGoBackClicked) {
            Text(text = "GO BACK!")
        }
    }
}

class GreetingScreenComponent(
    private val componentContext: ComponentContext,
    private val name: String,
    private val onGoBackClicked: () -> Unit,
) : Component, ComponentContext by componentContext {

    companion object {
        private val greetings = listOf(
            "Bonjour",
            "Hola",
            "Ola",
            "Ciao",
            "Hallo",
            "Hi",
            "Hey",
        )
    }

    @Composable
    override fun render() {
        GreetingScreen(
            greeting = "${greetings.random()}, $name",
            onGoBackClicked = onGoBackClicked,
        )
    }

}
