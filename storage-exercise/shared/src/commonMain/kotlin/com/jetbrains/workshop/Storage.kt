package com.jetbrains.workshop

fun saveString(key: String, value: String) {
    println("Saving string: $key, $value")
    persistString(key, value)
}

fun loadString(key: String): String {
    println("Loading string: $key")
    return restoreString(key)
}

expect fun persistString(key: String, value: String)
expect fun restoreString(key: String): String