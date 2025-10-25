package com.lisboa42.projects.calculator_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "calculator_app",
    ) {
        App()
    }
}