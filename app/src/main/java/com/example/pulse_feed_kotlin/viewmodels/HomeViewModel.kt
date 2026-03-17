package com.example.pulse_feed_kotlin.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.pulse_feed_kotlin.models.FeedItem

sealed class HomeState {
    object Initial : HomeState()
    data class AudioPlaying(val isPlaying: Boolean) : HomeState()
    data class VideoPlaying(val isPlaying: Boolean) : HomeState()
    data class DocumentLoading(val isLoading: Boolean) : HomeState()
    data class DocumentViewing(val filePath: String) : HomeState()
    data class Error(val message: String) : HomeState()
}

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Initial)
    val state: StateFlow<HomeState> = _state

    private val _feedItems = MutableStateFlow<List<FeedItem>>(FeedItem.sampleItems)
    val feedItems: StateFlow<List<FeedItem>> = _feedItems

    fun setAudioPlaying(isPlaying: Boolean) {
        _state.value = HomeState.AudioPlaying(isPlaying)
    }

    fun setVideoPlaying(isPlaying: Boolean) {
        _state.value = HomeState.VideoPlaying(isPlaying)
    }

    fun setDocumentLoading(isLoading: Boolean) {
        _state.value = HomeState.DocumentLoading(isLoading)
    }

    fun setDocumentViewing(filePath: String) {
        _state.value = HomeState.DocumentViewing(filePath)
    }

    fun setError(message: String) {
        _state.value = HomeState.Error(message)
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}
