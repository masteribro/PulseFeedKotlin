package com.example.pulse_feed_kotlin.services

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector

class VideoPlayerService(context: Context) {
    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context)
        .setTrackSelector(DefaultTrackSelector(context))
        .build()

    fun loadVideo(videoUrl: String) {
        val mediaItem = MediaItem.fromUri(videoUrl)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
    }

    fun play() {
        exoPlayer.play()
    }

    fun pause() {
        exoPlayer.pause()
    }

    fun seekTo(positionMs: Long) {
        exoPlayer.seekTo(positionMs)
    }

    fun getCurrentPosition(): Long = exoPlayer.currentPosition

    fun getDuration(): Long = exoPlayer.duration

    fun isPlaying(): Boolean = exoPlayer.isPlaying

    fun getExoPlayer(): ExoPlayer = exoPlayer

    fun release() {
        exoPlayer.release()
    }
}
