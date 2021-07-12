package ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import ui.Component


@Composable
fun InputScreen(
    name: String,
    onGoClicked: (String) -> Unit,
    onTextChanged: (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Greet Me!",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = name,
            maxLines = 1,
            label = { Text(text = "Enter your name") },

            onValueChange = onTextChanged
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                onGoClicked(name)
            }
        ) {
            Text(text = "GO!")
        }
    }

}


class InputScreenComponent(
    private val componentContext: ComponentContext,
    private val onGoClicked: (name: String) -> Unit,
): Component, ComponentContext by componentContext {

    private var state by mutableStateOf(Model())

    @Composable
    override fun render() {
        InputScreen(
            name = state.name,
            onGoClicked = onGoClicked,
            onTextChanged = {
                state = state.copy(name = it)
            }
        )
    }

    private data class Model(
        val name: String = "",
    )
}