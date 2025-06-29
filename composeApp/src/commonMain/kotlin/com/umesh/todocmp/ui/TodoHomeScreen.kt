package com.umesh.todocmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.umesh.todocmp.theme.ThemedScaffold
import com.umesh.todocmp.viewmodel.TodoViewModel

@Composable
fun TodoHomeScreen(
    viewModel: TodoViewModel, onAddTodoClick: () -> Unit
) {
    val todos = viewModel.todos.collectAsState()

    ThemedScaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddTodoClick,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Todo")
            }
        }) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(10.dp)
        ) {
            Text(
                text = "Todos", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp)
            )

            if (todos.value.isEmpty()) {
                EmptyTodoScreen(modifier = Modifier.fillMaxSize())
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(todos.value) { todo ->
                        TodoCard(todo, onDeleteClick = {
                            viewModel.deleteTodo(todo.id)
                        }, onCheckToggle = { isChecked ->
                            viewModel.updateTodo(todo.id, todo.title, isChecked, todo.priority)
                        })
                    }
                }
            }
        }
    }
}
