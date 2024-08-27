package com.jetbrains.workshop

import kotlin.coroutines.coroutineContext

fun goof() {
    val b = goof()
}

fun stdlib() {

}

expect fun getPlatform(): String