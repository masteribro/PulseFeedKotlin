package com.example.pulse_feed_kotlin.services

import android.content.Context
import android.media.MediaPlayer

class AudioPlayerService(context: Context) {
    private val mediaPlayer: MediaPlayer = MediaPlayer()
    private var onCompletionListener: (() -> Unit)? = null
    private var onPreparedListener: (() -> Unit)? = null
    private var isPrepared = false

    init {
        mediaPlayer.setOnCompletionListener {
            onCompletionListener?.invoke()
        }
        mediaPlayer.setOnPreparedListener {
            isPrepared = true
            onPreparedListener?.invoke()
        }
    }

    fun loadAudio(audioUrl: String, onPrepared: (() -> Unit)? = null) {
        try {
            onPreparedListener = onPrepared
            mediaPlayer.reset()
            mediaPlayer.setDataSource(audioUrl)
            mediaPlayer.prepareAsync()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun play() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    fun pause() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    fun seekTo(positionMs: Int) {
        mediaPlayer.seekTo(positionMs)
    }

    fun getCurrentPosition(): Int = mediaPlayer.currentPosition

    fun getDuration(): Int = mediaPlayer.duration

    fun isPlaying(): Boolean = mediaPlayer.isPlaying

    fun setOnCompletionListener(listener: (() -> Unit)?) {
        onCompletionListener = listener
    }

    fun release() {
        mediaPlayer.release()
    }
}
