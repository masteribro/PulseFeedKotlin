/**
 *  Item.kt
 *  PulseFeed
 *
 *  Created by Ibrahim Mohammed on 02/03/2026.
 */

package com.pulsefeed.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val timestamp: Date = Date()
)
