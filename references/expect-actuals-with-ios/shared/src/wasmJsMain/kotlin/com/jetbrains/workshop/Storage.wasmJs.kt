package com.jetbrains.workshop

import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window

actual fun persistString(key: String, value: String) {
    localStorage.setItem(key, value)
}

actual fun restoreString(key: String): String {
    return localStorage.getItem(key) ?: ""
}