package com.songify.app.network

import io.ktor.client.HttpClient
import javax.inject.Inject

class InnerTubeClient @Inject constructor(
    private val client: HttpClient
) {
    // Stub implementation for now
    suspend fun search(query: String): List<String> {
        return listOf("Song 1", "Song 2", "Song 3")
    }
}
