package view.player

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class VideoComponent(
    componentContext: ComponentContext
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        VideoScreen()
    }
}