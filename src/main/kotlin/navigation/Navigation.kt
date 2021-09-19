package navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.push
import com.arkivanov.decompose.router
import view.initialization.InitializationComponent
import view.home.HomeComponent
import view.player.PlayerComponent

class NavHostComponent(
    componentContext: ComponentContext,
) : Component, ComponentContext by componentContext {

    private val router = router<Screen, Component>(
        initialConfiguration =  Screen.Home,
        childFactory = ::createScreenComponent,
    )

    /**
     * Factory function to create screen from given ScreenConfig
     */
    private fun createScreenComponent(
        screen: Screen,
        componentContext: ComponentContext,
    ): Component {
        return when (screen) {

            is Screen.Home -> HomeComponent(componentContext, ::onAppStart)

            is Screen.Download -> InitializationComponent(componentContext, ::onMediaDownloadComplete)

            is Screen.Player -> PlayerComponent(componentContext)
        }
    }

    private fun onAppStart() {
        router.push(Screen.Download)
    }

    private fun onMediaDownloadComplete() {
        router.push(Screen.Player)
    }

    /**
     * Renders screen as per request
     */
    @Composable
    override fun render() {
        Children(routerState = router.state) {
            it.instance.render()
        }
    }
}