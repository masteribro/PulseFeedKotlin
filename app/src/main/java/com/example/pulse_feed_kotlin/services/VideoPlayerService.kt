package com.example.pulse_feed_kotlin.services

import android.content.Context
import android.util.Log
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector

class VideoPlayerService(context: Context) {
    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context)
        .setTrackSelector(DefaultTrackSelector(context))
        .build()

    init {
        exoPlayer.setPlayWhenReady(false)
    }

    fun loadVideo(videoUrl: String) {
        try {
            Log.d("VideoPlayerService", "Loading video: $videoUrl")
            val mediaItem = MediaItem.fromUri(videoUrl)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        } catch (e: Exception) {
            Log.e("VideoPlayerService", "Error loading video", e)
        }
    }

    fun play() {
        try {
            exoPlayer.play()
            Log.d("VideoPlayerService", "Playing video")
        } catch (e: Exception) {
            Log.e("VideoPlayerService", "Error playing video", e)
        }
    }

    fun pause() {
        try {
            exoPlayer.pause()
            Log.d("VideoPlayerService", "Paused video")
        } catch (e: Exception) {
            Log.e("VideoPlayerService", "Error pausing video", e)
        }
    }

    fun seekTo(positionMs: Long) {
        try {
            exoPlayer.seekTo(positionMs)
        } catch (e: Exception) {
            Log.e("VideoPlayerService", "Error seeking", e)
        }
    }

    fun getCurrentPosition(): Long = exoPlayer.currentPosition

    fun getDuration(): Long = exoPlayer.duration

    fun isPlaying(): Boolean = exoPlayer.isPlaying

    fun getExoPlayer(): ExoPlayer = exoPlayer

    fun release() {
        try {
            exoPlayer.release()
            Log.d("VideoPlayerService", "Video player released")
        } catch (e: Exception) {
            Log.e("VideoPlayerService", "Error releasing player", e)
        }
    }
}
