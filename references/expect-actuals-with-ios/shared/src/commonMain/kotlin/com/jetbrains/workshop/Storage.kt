package com.jetbrains.workshop

fun saveString(key: String, value: String) {
    println("Saving string: $key, $value")
    // TODO: create and call expect/actual function:
    persistString(key, value)
}

fun loadString(key: String): String {
    println("Loading string: $key")
    // TODO: create and call expect/actual function:
    return restoreString(key)
//    return ""
}

expect fun persistString(key: String, value: String)
expect fun restoreString(key: String): String