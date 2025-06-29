package com.umesh.todocmp.navigation

sealed class Screen {
    object Todo : Screen()
    object AddToDo : Screen()
}