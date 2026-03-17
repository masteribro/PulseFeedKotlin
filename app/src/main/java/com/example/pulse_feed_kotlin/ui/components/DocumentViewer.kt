package com.example.pulse_feed_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DocumentViewer(
    fileName: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE8F5E9),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    color = Color(0xFF4CAF50),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "📄",
                style = MaterialTheme.typography.displayLarge
            )
        }

        Text(
            text = fileName ?: "Document",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF2E7D32),
            modifier = Modifier.padding(top = 12.dp)
        )

        Text(
            text = "PDF Document",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
