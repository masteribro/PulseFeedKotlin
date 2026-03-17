package com.example.pulse_feed_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import com.example.pulse_feed_kotlin.services.VideoPlayerService

@Composable
fun VideoPlayerScreen(
    videoUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val videoService = remember { VideoPlayerService(context) }
    val isLoading = remember { mutableStateOf(true) }

    LaunchedEffect(videoUrl) {
        try {
            videoService.loadVideo(videoUrl)
            isLoading.value = false
        } catch (e: Exception) {
            e.printStackTrace()
            isLoading.value = false
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            // Don't release here - let it play in the background if user leaves
            // videoService.release()
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    player = videoService.getExoPlayer()
                    useController = true
                }
            },
            modifier = Modifier.fillMaxSize(),
            update = { playerView ->
                playerView.player = videoService.getExoPlayer()
            }
        )

        if (isLoading.value) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
