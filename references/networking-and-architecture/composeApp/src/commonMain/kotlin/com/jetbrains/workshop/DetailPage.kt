package com.jetbrains.workshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailPage(image: BirdImage, onBack: () -> Unit) {
    Box(Modifier.fillMaxSize().padding(16.dp)) {
        BirdImageCell(image, Modifier.fillMaxSize())
        Card(Modifier.align(Alignment.BottomCenter)) {
            Text("${image.category} by ${image.author}",
                modifier = Modifier.padding(16.dp)
            )
        }
        Button(onClick = onBack, Modifier.align(Alignment.TopStart)) {
            Text("Back")
        }
    }
}