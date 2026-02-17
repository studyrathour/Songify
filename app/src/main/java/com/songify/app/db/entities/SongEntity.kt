package com.songify.app.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class SongEntity(
    @PrimaryKey val id: String,
    val title: String,
    val duration: Int, // seconds
    val thumbnailUrl: String?,
    val liked: Boolean = false,
    val totalPlayTime: Long = 0,
    val inLibrary: Long? = null,
    val explicit: Boolean = false,
    val isVideo: Boolean = false,
    val isDownloaded: Boolean = false,
    val dateDownload: Long? = null, // Using Long for timestamp for simplicity
    val lyricsOffset: Int = 0,
    val isUploaded: Boolean = false
)
