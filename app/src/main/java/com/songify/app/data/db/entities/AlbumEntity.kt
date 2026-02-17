package com.songify.app.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album")
data class AlbumEntity(
    @PrimaryKey val id: String,
    val title: String,
    val year: Int?,
    val thumbnailUrl: String?,
    val songCount: Int,
    val duration: Int,
    val lastUpdateTime: Long,
    val bookmarkedAt: Long?,
    val browseId: String?,
    val description: String?,
    val isUploaded: Boolean
)
