package com.umesh.todocmp

import androidx.compose.ui.window.ComposeUIViewController
import com.umesh.todocmp.di.appModuleWithFactory
import com.umesh.todocmp.theme.TodoAppTheme
import com.umesh.todocmp.util.DatabaseDriverFactory
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    initKoinWithFactory()
    TodoAppTheme {
        MainApp()
    }
}

fun initKoinWithFactory() {
    startKoin {
        modules(appModuleWithFactory(DatabaseDriverFactory()))
    }
}