package io.jadu.glass_nav

import androidx.compose.ui.window.ComposeUIViewController
import io.jadu.glass_nav.di.appModule
import io.jadu.glass_nav.navigation.NativeTab
import io.jadu.glass_nav.navigation.NativeTabContent
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform
import platform.UIKit.UIViewController

fun initKoin() {
    if (KoinPlatform.getKoinOrNull() != null) return

    startKoin {
        modules(appModule)
    }
}

fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = { initKoin() }
) { App() }

fun TabViewController(tab: NativeTab): UIViewController =
    ComposeUIViewController {
        GlassNavTheme {
            NativeTabContent(tab)
        }
    }
