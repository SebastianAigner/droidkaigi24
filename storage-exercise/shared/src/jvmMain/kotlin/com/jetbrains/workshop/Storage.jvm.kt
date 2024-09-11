package com.jetbrains.workshop

import java.io.File

private val storageDir = File(System.getProperty("user.home"), ".myapp").apply { mkdirs() }

actual fun persistString(key: String, value: String) {
    File(storageDir, key).writeText(value)
}

actual fun restoreString(key: String): String {
    val file = File(storageDir, key)
    return if (file.exists()) file.readText() else ""
}
