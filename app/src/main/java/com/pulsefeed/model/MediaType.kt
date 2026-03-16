/**
 *  MediaType.kt
 *  PulseFeed
 *
 *  Created by Ibrahim Mohammed on 02/03/2026.
 */

package com.pulsefeed.model

enum class MediaType {
    VIDEO,
    AUDIO,
    DOCUMENT,
    TEXT;

    companion object {
        fun fromString(value: String): MediaType? {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}
