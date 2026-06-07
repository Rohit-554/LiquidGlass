import ComposeApp
import SwiftUI
import UIKit

struct LegacyComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(
        _ uiViewController: UIViewController,
        context: Context
    ) {}
}

@available(iOS 26.0, *)
struct ComposeTabView: UIViewControllerRepresentable {
    let tab: NativeTab

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.TabViewController(tab: tab)
    }

    func updateUIViewController(
        _ uiViewController: UIViewController,
        context: Context
    ) {}
}

@available(iOS 26.0, *)
struct LiquidGlassTabView: View {
    var body: some View {
        TabView {
            Tab("Home", systemImage: "house") {
                ComposeTabView(tab: NativeTab.home)
                    .ignoresSafeArea()
            }

            Tab("Explore", systemImage: "magnifyingglass") {
                ComposeTabView(tab: NativeTab.explore)
                    .ignoresSafeArea()
            }

            Tab("Favorites", systemImage: "heart") {
                ComposeTabView(tab: NativeTab.favorites)
                    .ignoresSafeArea()
            }

            Tab("Profile", systemImage: "person") {
                ComposeTabView(tab: NativeTab.profile)
                    .ignoresSafeArea()
            }
        }
        .tabBarMinimizeBehavior(.automatic)
        .tint(Color.accentColor)
    }
}

struct ContentView: View {
    var body: some View {
        if #available(iOS 26.0, *) {
            LiquidGlassTabView()
        } else {
            LegacyComposeView()
                .ignoresSafeArea()
        }
    }
}
