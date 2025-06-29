package com.umesh.todocmp.repository

import com.umesh.todocmp.database.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getAllTodos(): Flow<List<Todo>>
    suspend fun insertTodo(title: String, isDone: Boolean, priority: String)
    suspend fun deleteTodo(id: Long)
    suspend fun updateTodo(id: Long, title: String, isDone: Boolean, priority: String)
}