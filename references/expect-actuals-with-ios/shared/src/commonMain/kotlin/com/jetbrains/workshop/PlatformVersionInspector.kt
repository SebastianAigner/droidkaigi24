package com.jetbrains.workshop

interface PlatformVersionInspector {
    fun getPlatformVersion(): String
    fun getPlatformName(): String
}

expect fun createVersionInspector(): PlatformVersionInspector

fun logAnalytics() {
    val pvi: PlatformVersionInspector = TODO()
    println(pvi.getPlatformName())
    println(pvi.getPlatformVersion())
}