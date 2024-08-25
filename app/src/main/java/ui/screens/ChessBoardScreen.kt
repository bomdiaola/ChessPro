package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ChessBoardScreen(navController: NavHostController) {
    val boardSize = 8
    val squareSize = 40.dp // Tamaño fijo para las casillas

    val boardState by remember { mutableStateOf(generateInitialBoard()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Chess Game", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Box(modifier = Modifier.aspectRatio(1f)) {
            Column(modifier = Modifier.fillMaxSize()) {
                for (row in 0 until boardSize) {
                    Row {
                        for (col in 0 until boardSize) {
                            ChessSquare(
                                piece = boardState[row][col],
                                isDark = (row + col) % 2 == 1,
                                size = squareSize,
                                onClick = { /* lógica de movimiento */ }
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Exit Game")
        }
    }

    LaunchedEffect(boardState) {
        checkGameStatus(navController, boardState)
    }
}

@Composable
fun ChessSquare(piece: String?, isDark: Boolean, size: Dp, onClick: () -> Unit) {
    val backgroundColor = if (isDark) Color.Gray else Color.White
    Box(
        modifier = Modifier
            .size(size)
            .background(backgroundColor)
            .clickable { onClick() }
    ) {
        piece?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

fun generateInitialBoard(): List<List<String?>> {
    return listOf(
        listOf("R", "N", "B", "Q", "K", "B", "N", "R"),
        listOf("P", "P", "P", "P", "P", "P", "P", "P"),
        listOf(null, null, null, null, null, null, null, null),
        listOf(null, null, null, null, null, null, null, null),
        listOf(null, null, null, null, null, null, null, null),
        listOf(null, null, null, null, null, null, null, null),
        listOf("p", "p", "p", "p", "p", "p", "p", "p"),
        listOf("r", "n", "b", "q", "k", "b", "n", "r")
    )
}

fun checkGameStatus(navController: NavHostController, boardState: List<List<String?>>) {
    // Lógica para determinar si alguien ha ganado
    val winner = determineWinner(boardState)
    if (winner != null) {
        navController.navigate("game_result/$winner")
    }
}

fun determineWinner(boardState: List<List<String?>>): String? {
    // Lógica para determinar el ganador
    // Esto es solo un ejemplo; deberías implementar la lógica real del juego
    return "White" // o "Black", o null si no hay ganador todavía
}
