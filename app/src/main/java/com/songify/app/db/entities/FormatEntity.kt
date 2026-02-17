package com.songify.app.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "formats")
data class FormatEntity(
    @PrimaryKey val id: String, // Likely videoId
    val itag: Int,
    val mimeType: String,
    val codecs: String,
    val bitrate: Int,
    val sampleRate: Int? = null,
    val contentLength: Long,
    val loudnessDb: Float? = null,
    val perceptualLoudnessDb: Float? = null,
    val playbackUrl: String? = null
)
