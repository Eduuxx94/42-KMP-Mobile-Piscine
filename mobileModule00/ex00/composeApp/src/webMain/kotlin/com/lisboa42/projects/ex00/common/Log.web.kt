package com.lisboa42.projects.ex00.common

import kotlin.js.JsName

@JsName("console")
external object Console {
    fun log(message: Any?)
    fun warn(message: Any?)
    fun error(message: Any?)
}

actual object Log {
    actual fun d(tag: String, message: String) {
        Console.log("DEBUG: [$tag] $message")
    }

    actual fun i(tag: String, message: String) {
        Console.log("INFO: [$tag] $message")
    }

    actual fun w(tag: String, message: String) {
        Console.warn("WARN: [$tag] $message")
    }

    actual fun e(tag: String, message: String, throwable: Throwable?) {
        Console.error("ERROR: [$tag] $message")
        throwable?.let { Console.error(it.stackTraceToString()) }
    }
}