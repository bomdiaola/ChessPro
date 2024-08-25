package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun GameModeSelectionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Select Game Mode", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("bot_level_selection") },  // Navega a la pantalla de selección de nivel del bot
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Play Against Bot")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("game") },  // Navega directamente al juego si es modo jugador vs jugador local
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Two Players (Same Device)")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Aquí podrías agregar navegación a un futuro modo de juego online */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = false // Desactivado hasta que implementes el juego online
        ) {
            Text("Play Online (Coming Soon)")
        }
    }
}