package com.lisboa42.projects.weather_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "weather_app",
    ) {
        App()
    }
}