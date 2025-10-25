package com.lisboa42.projects.ex01

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ex01",
    ) {
        App()
    }
}