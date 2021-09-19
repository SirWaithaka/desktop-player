package view.initialization

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.lifecycle.doOnStop
import kotlinx.coroutines.*
import navigation.Component
import kotlin.coroutines.CoroutineContext

class InitializationComponent(
    private val componentContext: ComponentContext,
    val onMediaDownloadComplete: () -> Unit,
) : Component, ComponentContext by componentContext, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    init {
        lifecycle.doOnStop() {
            onStop()
        }
    }

    private suspend fun sleep() = coroutineScope {
        launch {
            delay(2000L)
            onMediaDownloadComplete()
        }
    }

    private fun onStop() {
        coroutineContext.cancelChildren()
        job.cancel()
    }

    @Composable
    override fun render() {
        InitializationScreen()

        launch {
            sleep()
        }
    }


}