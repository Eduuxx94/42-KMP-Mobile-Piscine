package com.lisboa42.projects.ex02

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform