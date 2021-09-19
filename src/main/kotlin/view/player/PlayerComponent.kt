package view.player

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.replaceCurrent
import com.arkivanov.decompose.router
import com.arkivanov.decompose.statekeeper.Parcelable
import navigation.Component

class PlayerComponent(componentContext: ComponentContext): Component, ComponentContext by componentContext {

    private val router = router<PlayerScreenConfig, Component>(
        initialConfiguration = PlayerScreenConfig.ImagePlayer,
        childFactory = ::createScreenComponent,
    )

    private fun createScreenComponent(screen: PlayerScreenConfig, componentContext: ComponentContext): Component {
        return when(screen) {
            is PlayerScreenConfig.ImagePlayer -> ImageComponent(componentContext)

            is PlayerScreenConfig.VideoPlayer -> VideoComponent(componentContext)
        }
    }

    private fun onMediaPlayFinish() {
        // do some logic, check playlist and determine next screen to display

        router.replaceCurrent(PlayerScreenConfig.VideoPlayer)
    }

    @Composable
    override fun render() {
        Children(routerState = router.state) {
            it.instance.render()
        }
    }

}

sealed class PlayerScreenConfig : Parcelable {
    object ImagePlayer : PlayerScreenConfig()
    object VideoPlayer: PlayerScreenConfig()
}