package io.jadu.glass_nav

import androidx.compose.ui.window.ComposeUIViewController
import io.jadu.glass_nav.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }
