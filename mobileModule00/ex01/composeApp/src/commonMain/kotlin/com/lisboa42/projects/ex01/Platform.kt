package com.lisboa42.projects.ex01

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform