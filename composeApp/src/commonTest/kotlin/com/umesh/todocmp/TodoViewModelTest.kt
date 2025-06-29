package com.umesh.todocmp

import com.umesh.todocmp.viewmodel.TodoViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TodoViewModelTest: KoinComponent {
    private lateinit var viewModel: TodoViewModel

    @BeforeTest
    fun setup() {
        startKoin {
            modules(testModule)
        }
        viewModel = get()
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `addTodo adds a new todo item`() = runTest {
        viewModel.addTodo("Learn compose", "MEDIUM")
        advanceUntilIdle()

        val todos = viewModel.todos.value
        assertEquals(1, todos.size)
        assertEquals("Learn compose", todos[0].title)
        assertEquals(0, todos[0].isDone)
        assertEquals("MEDIUM", todos[0].priority)
    }

    @Test
    fun `deleteTodo removes a todo item`() = runTest {
        viewModel.addTodo("Task 1", "LOW")
        advanceUntilIdle()
        val id = viewModel.todos.value[0].id
        viewModel.deleteTodo(id)
        advanceUntilIdle()
        assertTrue(viewModel.todos.value.isEmpty())
    }

    @Test
    fun `updateTodo updates a todo item`() = runTest {
        viewModel.addTodo("Task 1", "LOW")
        advanceUntilIdle()
        val id = viewModel.todos.value[0].id
        viewModel.updateTodo(id, "Task 2", true, "HIGH")
        advanceUntilIdle()

        val updatedTodo = viewModel.todos.value[0]
        assertEquals("Task 2", updatedTodo.title)
        assertEquals(1, updatedTodo.isDone)
        assertEquals("HIGH", updatedTodo.priority)
    }
}