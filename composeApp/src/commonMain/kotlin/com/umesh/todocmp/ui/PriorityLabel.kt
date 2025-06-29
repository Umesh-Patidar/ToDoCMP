package com.umesh.todocmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.umesh.todocmp.enum.Priority

@Composable
fun PriorityLabel(priority: String) {
    val (textColor, bgColor, borderColor) = when (priority) {
        Priority.HIGH.name -> Triple(Color.Red, Color(0xFFf8b4b4), Color.Red)
        Priority.MEDIUM.name -> Triple(Color.Blue, Color(0xFFEAF4FF), Color.Blue)
        Priority.LOW.name -> Triple(Color.Magenta, Color(0xFFF8EAFF), Color.Magenta)
        else -> Triple(Color.Gray, Color.LightGray, Color.Gray)
    }

    Box(
        modifier = Modifier
            .border(1.dp, borderColor, RoundedCornerShape(5.dp))
            .background(bgColor, RoundedCornerShape(5.dp))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = priority,
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
