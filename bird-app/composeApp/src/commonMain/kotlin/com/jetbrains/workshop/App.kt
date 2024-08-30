package com.jetbrains.workshop

import BirdRepository
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Composable
fun App() {
    BirdAppTheme {
        var birdImages by remember { mutableStateOf(emptyList<BirdImage>()) }
        LaunchedEffect(Unit) {
            birdImages = BirdRepository().getImages()
        }
        BirdsPage(
            uiState = BirdsUiState(birdImages, selectedCategory = null),
            onSelectCategory = { },
            onSelectImage = { }
        )
        if(birdImages.isEmpty()) {
            Text("No birds...")
        }
    }
}

@Composable
fun BirdsPage(uiState: BirdsUiState, onSelectCategory: (String) -> Unit, onSelectImage: (BirdImage) -> Unit = {}) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .heightIn(max = 100.dp),
        ) {
            for (category in uiState.categories) {
                RectButton(onSelectCategory, category, Modifier.weight(1f))
            }
        }

        AnimatedVisibility(visible = true) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(180.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
            ) {
                if (uiState.selectedCategory == null) {
                    items(uiState.images) { image ->
                        BirdImageCell(image, modifier = Modifier.clickable { onSelectImage(image) })
                    }
                } else {
                    items(uiState.selectedImages) { image ->
                        BirdImageCell(image, modifier = Modifier.clickable { onSelectImage(image) })
                    }
                }
            }
        }
    }
}

@Composable
private fun RectButton(onClick: (String) -> Unit, label: String, modifier: Modifier) {
    Button(
        onClick = { onClick(label) },
        modifier = modifier.size(200.dp, 100.dp)
    ) {
        Text(label)
    }
}

@Composable
fun BirdImageCell(image: BirdImage, modifier: Modifier = Modifier) {
    AsyncImage(
        "https://sebi.io/demo-image-api/${image.path}",
        contentDescription = "${image.category} by ${image.author}",
        contentScale = ContentScale.Crop,
        modifier = modifier.aspectRatio(1.0f).fillMaxWidth()
    )
}
