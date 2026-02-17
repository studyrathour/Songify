package com.songify.app.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlist")
data class PlaylistEntity(
    @PrimaryKey val id: String,
    val name: String,
    val browseId: String?,
    val bookmarkedAt: Long?,
    val isEditable: Boolean,
    val createdAt: Long,
    val lastUpdateTime: Long
)
