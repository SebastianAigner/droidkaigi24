package com.jetbrains.workshop

import platform.Foundation.NSUserDefaults

actual fun persistString(key: String, value: String) {
    NSUserDefaults.standardUserDefaults.setObject(value, forKey = key)
}

actual fun restoreString(key: String): String {
    return NSUserDefaults.standardUserDefaults.stringForKey(key) ?: ""
}