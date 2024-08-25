package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HelpScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "How to Play Chess", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Sección 1: Introducción al Ajedrez
        Text(text = "Introduction", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Chess is a strategic game played between two players on an 8x8 board. Each player controls an army of 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Sección 2: Objetivo del Juego
        Text(text = "Objective", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The objective of chess is to checkmate your opponent's king. This means the king is in a position to be captured (in check) and there is no legal move the player can make to prevent the king's capture.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Sección 3: Movimientos Básicos
        Text(text = "Basic Moves", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Each piece in chess moves differently. For example, the rook moves in straight lines horizontally or vertically, while the bishop moves diagonally.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Sección 4: Reglas Especiales
        Text(text = "Special Rules", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "There are some special rules in chess such as castling, en passant, and pawn promotion. These add depth to the strategy of the game.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para volver al menú principal
        Button(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Main Menu")
        }
    }
}
