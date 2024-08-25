package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class GameHistoryItem(val date: String, val opponent: String, val result: String)

@Composable
fun GameHistoryScreen(navController: NavHostController, gameHistory: List<GameHistoryItem>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Game History", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(gameHistory) { game ->
                GameHistoryRow(game)
                HorizontalDivider()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Main Menu")
        }
    }
}

@Composable
fun GameHistoryRow(game: GameHistoryItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = game.date, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Opponent: ${game.opponent}", style = MaterialTheme.typography.bodyMedium)
        }
        Text(text = game.result, style = MaterialTheme.typography.bodyLarge)
    }
}
