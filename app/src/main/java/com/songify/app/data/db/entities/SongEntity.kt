package com.songify.app.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "song")
data class SongEntity(
    @PrimaryKey val id: String,
    val title: String,
    val duration: Int,
    val thumbnailUrl: String?,
    val liked: Boolean,
    val totalPlayTime: Long,
    val inLibrary: Long?,
    val explicit: Boolean,
    val isVideo: Boolean,
    val isDownloaded: Boolean,
    val dateDownload: LocalDateTime?,
    val lyricsOffset: Int,
    val isUploaded: Boolean
)
