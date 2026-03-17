package com.example.pulse_feed_kotlin.services

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class AudioPlayerService(context: Context) {
    private val mediaPlayer: MediaPlayer = MediaPlayer()
    private var onCompletionListener: (() -> Unit)? = null
    private var onPreparedListener: (() -> Unit)? = null
    private var onErrorListener: ((String) -> Unit)? = null
    private var isPrepared = false

    init {
        mediaPlayer.setOnCompletionListener {
            isPrepared = false
            onCompletionListener?.invoke()
        }
        mediaPlayer.setOnPreparedListener {
            isPrepared = true
            Log.d("AudioPlayerService", "Audio prepared successfully")
            onPreparedListener?.invoke()
        }
        mediaPlayer.setOnErrorListener { mp, what, extra ->
            isPrepared = false
            val errorMsg = "MediaPlayer error: $what, $extra"
            Log.e("AudioPlayerService", errorMsg)
            onErrorListener?.invoke(errorMsg)
            true
        }
    }

    fun loadAudio(audioUrl: String, onPrepared: (() -> Unit)? = null) {
        try {
            onPreparedListener = onPrepared
            mediaPlayer.reset()
            mediaPlayer.setDataSource(audioUrl)
            mediaPlayer.prepareAsync()
            Log.d("AudioPlayerService", "Loading audio: $audioUrl")
        } catch (e: Exception) {
            Log.e("AudioPlayerService", "Error loading audio", e)
            isPrepared = false
            onErrorListener?.invoke(e.message ?: "Unknown error")
        }
    }

    fun play() {
        try {
            if (isPrepared && !mediaPlayer.isPlaying) {
                mediaPlayer.start()
                Log.d("AudioPlayerService", "Playing audio")
            }
        } catch (e: Exception) {
            Log.e("AudioPlayerService", "Error playing audio", e)
        }
    }

    fun pause() {
        try {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                Log.d("AudioPlayerService", "Paused audio")
            }
        } catch (e: Exception) {
            Log.e("AudioPlayerService", "Error pausing audio", e)
        }
    }

    fun seekTo(positionMs: Int) {
        try {
            if (isPrepared) {
                mediaPlayer.seekTo(positionMs)
            }
        } catch (e: Exception) {
            Log.e("AudioPlayerService", "Error seeking", e)
        }
    }

    fun getCurrentPosition(): Int {
        return try {
            mediaPlayer.currentPosition
        } catch (e: Exception) {
            0
        }
    }

    fun getDuration(): Int {
        return try {
            if (isPrepared) mediaPlayer.duration else 0
        } catch (e: Exception) {
            0
        }
    }

    fun isPlaying(): Boolean = mediaPlayer.isPlaying

    fun setOnCompletionListener(listener: (() -> Unit)?) {
        onCompletionListener = listener
    }

    fun setOnErrorListener(listener: ((String) -> Unit)?) {
        onErrorListener = listener
    }

    fun release() {
        try {
            mediaPlayer.release()
            isPrepared = false
        } catch (e: Exception) {
            Log.e("AudioPlayerService", "Error releasing player", e)
        }
    }
}
