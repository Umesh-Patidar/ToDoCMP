package com.umesh.todocmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform