package com.songify.app.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lyrics")
data class LyricsEntity(
    @PrimaryKey val id: String, // Likely videoId
    val lyrics: String // LRC or plain text
)
