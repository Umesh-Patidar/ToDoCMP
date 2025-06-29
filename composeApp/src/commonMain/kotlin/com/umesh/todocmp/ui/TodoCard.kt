package com.umesh.todocmp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.umesh.todocmp.database.Todo

@Composable
fun TodoCard(todo: Todo, onDeleteClick: (Long) -> Unit, onCheckToggle: (Boolean) -> Unit) {
    val textAlpha = if (todo.isDone != 0L) 0.4f else 1f

    Card(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
    ) {
        Column(
            modifier = Modifier.padding(15.dp).alpha(textAlpha)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
            ) {
                // Circular Delete Button
                IconButton(
                    onClick = { onDeleteClick(todo.id) }, modifier = Modifier.size(24.dp)
                ) {
                    Icon(Icons.Default.Cancel, contentDescription = "Delete")
                }

                Spacer(modifier = Modifier.width(20.dp))

                // Title
                Text(
                    text = todo.title, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium), modifier = Modifier.weight(1f)
                )

                // Checkbox
                Checkbox(
                    checked = todo.isDone != 0L, onCheckedChange = onCheckToggle
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Priority Label
            PriorityLabel(priority = todo.priority)
        }
    }

}
