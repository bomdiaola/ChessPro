package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BotLevelSelectionScreen(navController: NavHostController) {
    var selectedLevel by remember { mutableStateOf("Easy") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Select Bot Level", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        // Botones de selección de nivel
        LevelButton(level = "Easy", selectedLevel = selectedLevel) {
            selectedLevel = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        LevelButton(level = "Medium", selectedLevel = selectedLevel) {
            selectedLevel = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        LevelButton(level = "Hard", selectedLevel = selectedLevel) {
            selectedLevel = it
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate("game") // Navega al tablero de ajedrez con el nivel seleccionado
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("START GAME")
        }
    }
}

@Composable
fun LevelButton(level: String, selectedLevel: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(level) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedLevel == level) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(level)
    }
}