package com.jetbrains.workshop

import android.app.Application
import android.content.Context

val context get() = ContextHelper.currentContext!!

actual fun persistString(key: String, value: String) {
    val file = java.io.File(context.filesDir, key)
    file.writeText(value)
}

actual fun restoreString(key: String): String {
    val file = java.io.File(context.filesDir, key)
    return if (file.exists()) file.readText() else ""
}