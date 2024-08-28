package com.jetbrains.workshop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import coil3.compose.AsyncImage
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Composable
fun App() {
    BirdAppTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = HomeRoute) {
            composable<HomeRoute> {
                val birdsViewModel = viewModel(BirdsViewModel::class, factory = viewModelFactory {
                    initializer { BirdsViewModel() }
                })

                val uiState by birdsViewModel.uiState.collectAsState()
                LaunchedEffect(birdsViewModel) {
                    birdsViewModel.updateImages()
                }
                BirdsPage(
                    uiState = uiState,
                    onSelectCategory = { birdsViewModel.selectCategory(it) },
                    onSelectImage = { navController.navigate(it) }
                )
            }
            composable<BirdImage> {
                val thing = it.toRoute<BirdImage>()
                DetailPage(thing, { navController.popBackStack() })
            }
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

        AnimatedVisibility(visible = uiState.selectedImages.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(180.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
            ) {
                items(uiState.selectedImages) { image ->
                    BirdImageCell(image, modifier = Modifier.clickable { onSelectImage(image) })
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
