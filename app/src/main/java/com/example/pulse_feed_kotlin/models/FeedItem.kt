package com.example.pulse_feed_kotlin.models

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import java.util.UUID

@Parcelize
data class FeedItem(
    val id: String = UUID.randomUUID().toString(),
    val type: MediaType,
    val title: String,
    val description: String? = null,
    val mediaUrl: String? = null,
    val assetName: String? = null,
    val fileName: String? = null
) : Parcelable {
    companion object {
        val sampleItems = listOf(
            FeedItem(
                type = MediaType.VIDEO,
                title = "VideoChannel",
                description = "Watch this cute cat doing tricks 🐱 #Cats #Funny",
                mediaUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            ),
            FeedItem(
                type = MediaType.AUDIO,
                title = "PodcastDaily",
                description = "Start your day with this amazing podcast ☀️ #MorningMotivation",
                mediaUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
            ),
            FeedItem(
                type = MediaType.DOCUMENT,
                title = "My CV",
                description = "Mohamed Ibrahim's CV 📄",
                assetName = "Mohamed_Ibrahim_CV",
                fileName = "Mohamed_Ibrahim_CV.pdf"
            ),
            FeedItem(
                type = MediaType.TEXT,
                title = "DailyThoughts",
                description = "Just finished building this awesome app! 🚀\n\nFeeling proud of what we've accomplished. The journey of learning Kotlin has been amazing.\n\n#AndroidDev #MobileApps #CodingLife"
            ),
            FeedItem(
                type = MediaType.TEXT,
                title = "WeatherUpdate",
                description = "Beautiful sunny day here in California! ☀️ 75°F and perfect for coding."
            ),
            FeedItem(
                type = MediaType.TEXT,
                title = "TechNews",
                description = "Breaking: New Android version just dropped! Check out the amazing new features 🔥"
            )
        )
    }
}

object SampleData {
    val feedItems = FeedItem.sampleItems
}
