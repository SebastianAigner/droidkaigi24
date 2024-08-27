package com.jetbrains.workshop
import java.util.concurrent.ConcurrentHashMap

fun foo() {
    val cchm = ConcurrentHashMap<String, String>()
}
class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): String {
    "Java ${System.getProperty("java.version")}"
}