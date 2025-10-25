package com.lisboa42.projects.calculator_app.common

import android.util.Log as AndroidLog

actual object Log {
    actual fun d(tag: String, message: String) {
        AndroidLog.d(tag, message)
    }

    actual fun i(tag: String, message: String) {
        AndroidLog.i(tag, message)
    }

    actual fun w(tag: String, message: String) {
        AndroidLog.w(tag, message)
    }

    actual fun e(tag: String, message: String, throwable: Throwable?) {
        AndroidLog.e(tag, message, throwable)
    }
}
