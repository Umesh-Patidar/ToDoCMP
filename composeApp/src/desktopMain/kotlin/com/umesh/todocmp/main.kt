package com.umesh.todocmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.umesh.todocmp.di.appModuleWithFactory
import com.umesh.todocmp.util.DatabaseDriverFactory
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(appModuleWithFactory(DatabaseDriverFactory()))
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "ToDoCMP",
    ) {
        MainApp()
    }
}
