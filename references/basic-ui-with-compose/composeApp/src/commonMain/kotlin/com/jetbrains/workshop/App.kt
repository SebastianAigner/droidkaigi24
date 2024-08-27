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
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform

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
        Column(
            Modifier.fillMaxSize().verticalScroll(rememberScrollState()).background(Color.White).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Habit Tracker", fontSize = MaterialTheme.typography.h4.fontSize)
            for (exercise in exercises) {
                HabitTrackerItem(exercise, 10)
            }
        }
    }
}

@Composable
fun HabitTrackerItem(habitLabel: String, habitCount: Int) {
    var labelState by remember { mutableStateOf(habitLabel) }
    var habitCountState by remember { mutableStateOf(habitCount) }
    Row(
        Modifier.fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = labelState,
            onValueChange = { labelState = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Label") },
        )
        CircularButton(onClick = { habitCountState-- }) { Text("-") }
        Text(habitCountState.toString())
        CircularButton(onClick = { habitCountState++ }) { Text("+") }
    }

}

@Composable
fun CircularButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    Button(
        onClick = onClick,
        Modifier.size(40.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) { content() }
}

@Preview
@Composable
fun HabitTrackerItemView() {
    HabitTrackerItem(
        "Pull-ups",
        10
    )
}


















