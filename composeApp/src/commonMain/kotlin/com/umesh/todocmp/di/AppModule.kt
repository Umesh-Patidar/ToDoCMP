package com.umesh.todocmp.di
import app.cash.sqldelight.db.SqlDriver
import com.umesh.todocmp.util.DatabaseDriverFactory
import com.umesh.todocmp.database.AppDatabase
import com.umesh.todocmp.repository.TodoRepository
import com.umesh.todocmp.repository.TodoRepositoryImpl
import com.umesh.todocmp.viewmodel.TodoViewModel
import org.koin.dsl.module

fun appModuleWithFactory(factory: DatabaseDriverFactory) = module {
    single<SqlDriver> { factory.createDriver() }
    single { AppDatabase(factory.createDriver()) }
    single<TodoRepository> { TodoRepositoryImpl(get()) }
    factory { TodoViewModel(get()) }
}