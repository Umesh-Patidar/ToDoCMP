package com.umesh.todocmp.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.umesh.todocmp.enum.Priority
import com.umesh.todocmp.theme.ThemedScaffold
import com.umesh.todocmp.util.HandleBackPress

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddToDoScreen(
    onAddTodoClick: (String, String) -> Unit,
    onBackClick: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var priorityLevel by remember { mutableStateOf(0f) }

    val priorityText = when (priorityLevel.toInt()) {
        0 -> Priority.LOW.name
        1 -> Priority.MEDIUM.name
        else -> Priority.HIGH.name
    }

    HandleBackPress(onBackClick)

    ThemedScaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize().onKeyEvent {
                    if (it.type == KeyEventType.KeyUp && it.key == Key.Escape) {
                        onBackClick()
                        true
                    } else false
                }
                .padding(innerPadding)
                .padding(16.dp).imePadding()
        ) {
            Text(
                text = "Add Todo",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("Todo", style = MaterialTheme.typography.titleSmall)

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("What needs to be done?") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Sentences
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("Priority: $priorityText", style = MaterialTheme.typography.titleSmall)

            Slider(
                value = priorityLevel,
                onValueChange = { priorityLevel = it },
                valueRange = 0f..2f,
                steps = 1,
                modifier = Modifier.fillMaxWidth(),
                thumb = {
                    SliderDefaults.Thumb(
                        interactionSource = remember { MutableInteractionSource() },
                        modifier = Modifier.size(16.dp)
                    )
                },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTrackColor = MaterialTheme.colorScheme.primary
                )
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(Priority.LOW.name)
                Text(Priority.MEDIUM.name, textAlign = TextAlign.Center)
                Text(Priority.HIGH.name, textAlign = TextAlign.End)
            }

            Spacer(modifier = Modifier.weight(1f)) // Push buttons to bottom

            Row {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = onBackClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        if (title.isNotBlank()) {
                            onAddTodoClick(title, priorityText)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Add")
                }
            }
        }
    }
}
