package com.jetbrains.workshop

import android.content.Context

val context get() = ContextHelper.currentContext!!

actual fun persistString(key: String, value: String) {
    context.openFileOutput(key, Context.MODE_PRIVATE).use { outputStream ->
        outputStream.write(value.toByteArray())
    }
}

actual fun restoreString(key: String): String {
    return try {
        context.openFileInput(key).bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        ""  // ファイルが見つからない場合や読み込みエラーの場合は空文字列を返す
    }
}
