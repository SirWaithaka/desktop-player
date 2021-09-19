package navigation

import com.arkivanov.decompose.statekeeper.Parcelable

sealed class Screen : Parcelable {
    object Home: Screen()
    object Download: Screen()
    object Player: Screen()
}
