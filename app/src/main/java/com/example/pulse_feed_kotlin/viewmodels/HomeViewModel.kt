package com.example.pulse_feed_kotlin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class HomeViewModel : ViewModel() {
    
    companion object {
        fun provideFactory(context: Any): ViewModelProvider.Factory {
            return viewModelFactory {
                initializer {
                    HomeViewModel()
                }
            }
        }
    }
}
