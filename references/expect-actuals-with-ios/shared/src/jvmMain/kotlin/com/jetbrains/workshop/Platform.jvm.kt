package com.jetbrains.workshop

actual fun getPlatform(): String {
    return "Java ${System.getProperty("java.version")}"
}