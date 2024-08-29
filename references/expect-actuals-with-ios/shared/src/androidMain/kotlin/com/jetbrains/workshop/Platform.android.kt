package com.jetbrains.workshop

import android.os.Build

actual fun getPlatform(): String {
    return "Android ${Build.VERSION.SDK_INT}"
}