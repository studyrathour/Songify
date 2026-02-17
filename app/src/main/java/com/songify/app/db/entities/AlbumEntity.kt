package com.songify.app.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey val id: String,
    val title: String,
    val year: Int? = null,
    val thumbnailUrl: String? = null,
    val songCount: Int = 0,
    val duration: Int = 0, // seconds
    val lastUpdateTime: Long = 0,
    val bookmarkedAt: Long? = null,
    val browseId: String? = null,
    val description: String? = null,
    val isUploaded: Boolean = false
)
