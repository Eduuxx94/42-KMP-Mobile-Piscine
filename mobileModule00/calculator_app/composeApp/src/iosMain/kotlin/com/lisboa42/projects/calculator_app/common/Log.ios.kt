package com.lisboa42.projects.calculator_app.common

import platform.Foundation.NSLog

actual object Log {
    actual fun d(tag: String, message: String) {
        NSLog("DEBUG: [%@] %@", tag, message)
    }

    actual fun i(tag: String, message: String) {
        NSLog("INFO:  [%@] %@", tag, message)
    }

    actual fun w(tag: String, message: String) {
        NSLog("WARN:  [%@] %@", tag, message)
    }

    actual fun e(tag: String, message: String, throwable: Throwable?) {
        NSLog("ERROR: [%@] %@", tag, message)
        throwable?.let { NSLog("Exception: %@", it.message ?: "Unknown") }
    }
}