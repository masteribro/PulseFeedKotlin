package com.example.pulse_feed_kotlin.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulse_feed_kotlin.models.SampleData
import com.example.pulse_feed_kotlin.ui.components.FeedItemCard
import com.example.pulse_feed_kotlin.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PulseFeed") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(SampleData.feedItems) { feedItem ->
                FeedItemCard(
                    feedItem = feedItem,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
        }
    }
}
