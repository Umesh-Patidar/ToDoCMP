package com.umesh.todocmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.umesh.todocmp.navigation.Screen
import com.umesh.todocmp.ui.AddToDoScreen
import com.umesh.todocmp.theme.TodoAppTheme
import com.umesh.todocmp.ui.SplashScreen
import com.umesh.todocmp.ui.TodoHomeScreen
import com.umesh.todocmp.util.getPlatformDarkTheme
import com.umesh.todocmp.viewmodel.TodoViewModel
import org.koin.compose.koinInject

@Composable
fun MainApp() {
    val viewModel: TodoViewModel = koinInject()
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Todo) }
    var showSplash by remember { mutableStateOf(true) }

    TodoAppTheme(useDarkTheme = getPlatformDarkTheme()) {
        if (showSplash) {
            SplashScreen(onFinished = { showSplash = false })
        } else {
            when (currentScreen) {
                Screen.Todo -> TodoHomeScreen(viewModel, onAddTodoClick = {
                    currentScreen = Screen.AddToDo
                })

                Screen.AddToDo -> AddToDoScreen(onAddTodoClick = { title, priority ->
                    viewModel.addTodo(title, priority)
                    currentScreen = Screen.Todo
                }, onBackClick = {
                    currentScreen = Screen.Todo
                })
            }
        }
    }
}