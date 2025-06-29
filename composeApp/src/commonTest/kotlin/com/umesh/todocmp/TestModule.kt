package com.umesh.todocmp

import com.umesh.todocmp.repository.TodoRepository
import com.umesh.todocmp.viewmodel.TodoViewModel
import org.koin.dsl.module

val testModule = module {
    single<TodoRepository> { FakeTodoRepository() }
    single { TodoViewModel(get()) }
}