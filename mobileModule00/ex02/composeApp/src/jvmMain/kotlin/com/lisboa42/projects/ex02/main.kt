package com.lisboa42.projects.ex02

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ex02",
    ) {
        App()
    }
}