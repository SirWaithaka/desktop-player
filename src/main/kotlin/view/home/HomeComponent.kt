package view.home

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.lifecycle.doOnStop
import kotlinx.coroutines.*
import navigation.Component
import kotlin.coroutines.CoroutineContext

class HomeComponent(
    private val componentContext: ComponentContext,
    val onInit: () -> Unit,
) : Component, ComponentContext by componentContext, CoroutineScope  {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    init {
        lifecycle.doOnStop() {
            onStop()
        }
    }

    suspend fun sleep() = coroutineScope {
        launch {
           delay(2000L)
            onInit()
        }
    }

    private fun onStop() {
        coroutineContext.cancelChildren()
        job.cancel()
    }

    @Composable
    override fun render() {
        HomeScreen()

        launch {
            sleep()
        }
    }

}
