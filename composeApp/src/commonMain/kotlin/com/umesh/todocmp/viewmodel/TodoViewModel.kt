package com.umesh.todocmp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umesh.todocmp.repository.TodoRepository
import com.umesh.todocmp.database.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos.asStateFlow()

    init {
        observeTodos()
    }

    private fun observeTodos() {
        viewModelScope.launch {
            repository.getAllTodos().collect {
                _todos.value = it
            }
        }
    }

    fun addTodo(title: String, priority: String) {
        viewModelScope.launch {
            repository.insertTodo(title, false, priority)
        }
    }

    fun deleteTodo(id: Long) {
        viewModelScope.launch {
            repository.deleteTodo(id)
        }
    }

    fun updateTodo(id: Long, title: String, isDone: Boolean, priority: String) {
        viewModelScope.launch {
            repository.updateTodo(id, title, isDone, priority)
        }
    }
}