package io.jadu.glass_nav.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.jadu.glass_nav.ui.screens.TabScreen

enum class NativeTab {
    HOME,
    EXPLORE,
    FAVORITES,
    PROFILE
}

@Composable
fun NativeTabContent(tab: NativeTab) {
    when (tab) {
        NativeTab.HOME -> TabScreen(
            title = "HOME",
            backgroundColor = Color(0xFFDCEFE6)
        )

        NativeTab.EXPLORE -> TabScreen(
            title = "EXPLORE",
            backgroundColor = Color(0xFFDDEAF7)
        )

        NativeTab.FAVORITES -> TabScreen(
            title = "FAVORITES",
            backgroundColor = Color(0xFFF3E5D8)
        )

        NativeTab.PROFILE -> TabScreen(
            title = "PROFILE",
            backgroundColor = Color(0xFFE9E1F4)
        )
    }
}
