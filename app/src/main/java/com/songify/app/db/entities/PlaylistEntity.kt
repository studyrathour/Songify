package com.songify.app.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey val id: String,
    val name: String,
    val browseId: String? = null,
    val bookmarkedAt: Long? = null,
    val isEditable: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val lastUpdateTime: Long = System.currentTimeMillis()
)
