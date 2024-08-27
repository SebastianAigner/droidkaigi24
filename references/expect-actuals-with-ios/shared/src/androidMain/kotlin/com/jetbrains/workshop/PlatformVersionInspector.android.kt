package com.jetbrains.workshop

class AndroidPlatformVersionInspector : PlatformVersionInspector {
    override fun getPlatformVersion(): String =
        android.os.Build.VERSION.SDK_INT.toString()

    override fun getPlatformName(): String =
        "Android"
}

actual fun createVersionInspector(): PlatformVersionInspector {
    return AndroidPlatformVersionInspector()
}

