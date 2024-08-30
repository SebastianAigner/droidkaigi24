package com.jetbrains.workshop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.*
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    val exercises = listOf(
        "Running",
        "Pull-ups",
        "Squats",
        "Plank",
        "Dumbbells",
        "Jogging",
        "Push-ups",
        "Lunges",
        "Sit-ups",
        "High knees",
        "Burpees",
    )
    MaterialTheme {
        Box(Modifier.fillMaxSize().background(Color.White)) {
            
        }
    }
}

@Composable
fun MyElement(label: String) {
    Column {
        Text(label)
        Text(label)
        Text(label)
    }
}

@Preview
@Composable
fun MyElementPreview() {
    MyElement("Hello")
}
















