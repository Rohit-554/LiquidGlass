package io.jadu.glass_nav

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.jadu.glass_nav.navigation.AppNavigation

@Composable
@Preview
fun App() {
    GlassNavTheme {
        AppNavigation()
    }
}

@Composable
fun GlassNavTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}
