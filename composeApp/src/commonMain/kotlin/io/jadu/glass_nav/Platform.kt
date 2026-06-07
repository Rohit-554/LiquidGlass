package io.jadu.glass_nav

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
