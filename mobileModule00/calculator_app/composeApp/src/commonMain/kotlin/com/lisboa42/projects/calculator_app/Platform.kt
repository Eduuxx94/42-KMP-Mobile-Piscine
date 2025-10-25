package com.lisboa42.projects.calculator_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform