package com.lisboa42.projects.ex00

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform