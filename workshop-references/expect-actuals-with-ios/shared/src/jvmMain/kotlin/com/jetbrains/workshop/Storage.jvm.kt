package com.jetbrains.workshop

import java.io.File

actual fun persistString(key: String, value: String) {
    File("$key.txt").writeText(value)
}

actual fun restoreString(key: String): String {
    val file = File("$key.txt")
    if(!file.exists()) return ""
    return file.readText()
}