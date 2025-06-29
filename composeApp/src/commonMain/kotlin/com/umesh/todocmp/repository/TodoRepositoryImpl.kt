package com.umesh.todocmp.repository

import com.umesh.todocmp.database.AppDatabase
import com.umesh.todocmp.database.Todo
import kotlinx.coroutines.flow.Flow
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class TodoRepositoryImpl(database: AppDatabase): TodoRepository {
    val queries = database.todoQueries

    override fun getAllTodos(): Flow<List<Todo>> {
       return queries.selectAll().asFlow().mapToList(Dispatchers.IO)
    }

    override suspend fun insertTodo(title: String, isDone: Boolean, priority: String) {
        queries.insertTodo(title, if (isDone) 1L else 0L, priority)
    }

    override suspend fun deleteTodo(id: Long) {
        queries.deleteTodo(id)
    }

    override suspend fun updateTodo(id: Long, title: String, isDone: Boolean, priority: String) {
        queries.updateTodo(title, if (isDone) 1L else 0L, priority, id)
    }
}