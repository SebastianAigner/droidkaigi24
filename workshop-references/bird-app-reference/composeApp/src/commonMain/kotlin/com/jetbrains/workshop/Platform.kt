package com.jetbrains.workshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform