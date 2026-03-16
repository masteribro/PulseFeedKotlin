/**
 *  PulseFeedApp.kt
 *  PulseFeed
 *
 *  Created by Ibrahim Mohammed on 02/03/2026.
 */

package com.pulsefeed

import android.app.Application
import android.graphics.Color
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

class PulseFeedApp : Application() {

    override fun onCreate() {
        super.onCreate()
        configureAppearance()
    }

    private fun configureAppearance() {
        // Force light theme across the app
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        
        // Note: For Compose, use Compose theme configuration
        // For legacy views, you would set ActionBar styling here
    }
}
