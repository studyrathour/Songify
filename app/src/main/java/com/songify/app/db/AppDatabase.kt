package com.songify.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.songify.app.db.daos.SongDao
import com.songify.app.db.entities.AlbumEntity
import com.songify.app.db.entities.ArtistEntity
import com.songify.app.db.entities.FormatEntity
import com.songify.app.db.entities.LyricsEntity
import com.songify.app.db.entities.PlaylistEntity
import com.songify.app.db.entities.SearchHistory
import com.songify.app.db.entities.SongEntity

@Database(
    entities = [
        SongEntity::class,
        ArtistEntity::class,
        AlbumEntity::class,
        PlaylistEntity::class,
        FormatEntity::class,
        LyricsEntity::class,
        SearchHistory::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
}
