package io.jadu.glass_nav.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey {
    @Serializable
    data object Home : Screen

    @Serializable
    data object Explore : Screen

    @Serializable
    data object Favorites : Screen

    @Serializable
    data object Profile : Screen
}
