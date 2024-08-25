package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PauseScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Game Paused", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.popBackStack() },  // Regresa al juego
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Resume Game")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("game")
                // Lógica para reiniciar el juego puede ir aquí
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Restart Game")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("main_menu") },  // Regresa al menú principal
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Exit to Main Menu")
        }
    }
}
