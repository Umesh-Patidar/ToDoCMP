package com.umesh.todocmp

import com.umesh.todocmp.database.Todo
import com.umesh.todocmp.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeTodoRepository: TodoRepository {
    private val todos = MutableStateFlow<List<Todo>>(emptyList())

    override fun getAllTodos(): Flow<List<Todo>> {
        return todos
    }

    override suspend fun insertTodo(title: String, isDone: Boolean, priority: String) {
        val id = (todos.value.maxOfOrNull { it.id } ?: 0L) + 1
        val newTodo = Todo(id, title, if (isDone) 1 else 0, priority)
        todos.value = todos.value + newTodo
    }

    override suspend fun deleteTodo(id: Long) {
        todos.value = todos.value.filterNot { it.id == id }
    }

    override suspend fun updateTodo(id: Long, title: String, isDone: Boolean, priority: String) {
        todos.value = todos.value.map {
            if (it.id == id) it.copy(title = title, isDone = if (isDone) 1 else 0, priority = priority) else it
        }
    }
}