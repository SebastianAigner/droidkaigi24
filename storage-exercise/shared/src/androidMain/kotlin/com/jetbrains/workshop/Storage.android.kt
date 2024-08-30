package com.jetbrains.workshop

actual fun persistString(key: String, value: String) {
    val context = android.content.ContextWrapper(null)
    val file = java.io.File(context.filesDir, key)
    file.writeText(value)
}

actual fun restoreString(key: String): String {
    val context = android.content.ContextWrapper(null)
    val file = java.io.File(context.filesDir, key)
    return if (file.exists()) file.readText() else ""
}