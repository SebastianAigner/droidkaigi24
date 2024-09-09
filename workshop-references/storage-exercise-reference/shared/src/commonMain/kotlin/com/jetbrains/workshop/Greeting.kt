package com.jetbrains.workshop

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform}!"
    }
}