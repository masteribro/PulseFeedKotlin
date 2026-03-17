package com.example.pulse_feed_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulse_feed_kotlin.models.FeedItem
import com.example.pulse_feed_kotlin.models.MediaType

@Composable
fun FeedItemCard(feedItem: FeedItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        // Badge for media type
        val typeLabel = when (feedItem.type) {
            MediaType.VIDEO -> "VIDEO"
            MediaType.AUDIO -> "AUDIO"
            MediaType.DOCUMENT -> "DOCUMENT"
            MediaType.TEXT -> "TEXT"
        }
        
        Text(
            text = typeLabel,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Blue,
            modifier = Modifier
                .background(Color(0xFFE3F2FD), shape = RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
        
        // Title
        Text(
            text = feedItem.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 12.dp)
        )
        
        // Description
        if (feedItem.description != null) {
            Text(
                text = feedItem.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
