package com.jetbrains.workshop

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): String {
    return "Web with Kotlin/Wasm"
}