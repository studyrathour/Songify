package com.songify.app.ui.player

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.AsyncImage
import com.songify.app.ui.theme.*

@Composable
fun NowPlayingScreen(
    onBack: () -> Unit = {},
    onOptions: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize().background(BackgroundDark)) {
        // Background Layers
        // Layer 1: Album Art Blur
        AsyncImage(
            model = "https://example.com/album_art.jpg", // Placeholder
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.2f)
                .blur(60.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.6f
        )

        // Layer 2: Gradient Overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color(0xCC131022), // 80% opacity
                        0.2f to Color(0x66131022), // 40%
                        0.8f to Color(0x66131022), // 40%
                        1f to Color(0xE6131022) // 90%
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            PlayerHeader(onBack, onOptions)

            // Lyrics Area (Takes available space)
            LyricsArea(modifier = Modifier.weight(1f))

            // Bottom Section: Progress + Controls + Actions
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 32.dp)
            ) {
                PlayerProgress()
                Spacer(modifier = Modifier.height(24.dp))
                PlayerControls()
                Spacer(modifier = Modifier.height(32.dp))
                PlayerActionBar()
            }
        }
    }
}

@Composable
fun PlayerHeader(onBack: () -> Unit, onOptions: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .height(80.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .size(40.dp)
                .background(Color(0x1AFFFFFF), CircleShape)
        ) {
            Icon(Icons.Filled.KeyboardArrowDown, "Minimize", tint = Color.White)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "NOW PLAYING",
                style = MaterialTheme.typography.labelSmall.copy(
                    letterSpacing = 0.2.em,
                    fontWeight = FontWeight.Bold,
                    color = TextSecondary
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Song Title",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Artist • Album",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }

        IconButton(
            onClick = onOptions,
            modifier = Modifier
                .size(40.dp)
                .background(Color(0x1AFFFFFF), CircleShape)
        ) {
            Icon(Icons.Filled.MoreHoriz, "Options", tint = Color.White)
        }
    }
}

@Composable
fun LyricsArea(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(10) { index ->
            Text(
                text = "Lyric Line ${index + 1}",
                style = if (index == 4)
                    MaterialTheme.typography.headlineLarge.copy(color = Color.White)
                else
                    MaterialTheme.typography.headlineSmall.copy(color = Color(0x4DFFFFFF)),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}

@Composable
fun PlayerProgress() {
    Column {
        LinearProgressIndicator(
            progress = { 0.3f },
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .clip(RoundedCornerShape(999.dp)),
            color = Primary,
            trackColor = Color(0x33FFFFFF)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("1:23", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
            Text("3:45", style = MaterialTheme.typography.labelSmall, color = TextSecondary)
        }
    }
}

@Composable
fun PlayerControls() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Shuffle, "Shuffle", tint = TextSecondary)
        }
        IconButton(onClick = {}) {
            Icon(Icons.Filled.SkipPrevious, "Previous", tint = Color.White, modifier = Modifier.size(32.dp))
        }

        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.White, CircleShape)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Filled.PlayArrow, "Play", tint = BackgroundDark, modifier = Modifier.size(32.dp))
        }

        IconButton(onClick = {}) {
            Icon(Icons.Filled.SkipNext, "Next", tint = Color.White, modifier = Modifier.size(32.dp))
        }
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Repeat, "Repeat", tint = TextSecondary)
        }
    }
}

@Composable
fun PlayerActionBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val iconTint = TextTertiary
        Icon(Icons.Outlined.Info, "Lyrics", tint = iconTint)
        Icon(Icons.Filled.Mic, "Mic", tint = iconTint)
        Icon(Icons.Filled.List, "Queue", tint = iconTint)
        Icon(Icons.Filled.Share, "Share", tint = iconTint)
    }
}
