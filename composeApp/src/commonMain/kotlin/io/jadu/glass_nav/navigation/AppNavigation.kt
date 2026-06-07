package io.jadu.glass_nav.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import io.jadu.glass_nav.ui.screens.TabScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

private data class BottomTab(
    val screen: Screen,
    val label: String,
    val shortLabel: String
)

private val bottomTabs = listOf(
    BottomTab(Screen.Home, "Home", "H"),
    BottomTab(Screen.Explore, "Explore", "E"),
    BottomTab(Screen.Favorites, "Favorites", "F"),
    BottomTab(Screen.Profile, "Profile", "P")
)

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(
        SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Screen.Home::class)
                    subclass(Screen.Explore::class)
                    subclass(Screen.Favorites::class)
                    subclass(Screen.Profile::class)
                }
            }
        },
        Screen.Home
    )

    val currentScreen = backStack.lastOrNull() as? Screen ?: Screen.Home

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFF8FAFC)
            ) {
                bottomTabs.forEach { tab ->
                    val selected = currentScreen == tab.screen

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                backStack.clear()
                                backStack.add(tab.screen)
                            }
                        },
                        icon = {
                            Text(
                                text = tab.shortLabel,
                                style = MaterialTheme.typography.titleMedium
                            )
                        },
                        label = { Text(tab.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF334155),
                            selectedTextColor = Color(0xFF334155),
                            indicatorColor = Color(0xFFE2E8F0),
                            unselectedIconColor = Color(0xFF94A3B8),
                            unselectedTextColor = Color(0xFF64748B)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Crossfade(
            targetState = currentScreen,
            modifier = Modifier.padding(innerPadding)
        ) { screen ->
            when (screen) {
                Screen.Home -> TabScreen(
                    title = "HOME",
                    backgroundColor = Color(0xFFDCEFE6)
                )

                Screen.Explore -> TabScreen(
                    title = "EXPLORE",
                    backgroundColor = Color(0xFFDDEAF7)
                )

                Screen.Favorites -> TabScreen(
                    title = "FAVORITES",
                    backgroundColor = Color(0xFFF3E5D8)
                )

                Screen.Profile -> TabScreen(
                    title = "PROFILE",
                    backgroundColor = Color(0xFFE9E1F4)
                )
            }
        }
    }
}
