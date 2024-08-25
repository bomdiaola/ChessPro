package ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ui.screens.*

@Composable
fun ChessNavHost(navController: NavHostController) {
    val sampleHistory = listOf(
        GameHistoryItem("2024-08-25", "Player 1", "Win"),
        GameHistoryItem("2024-08-24", "Player 2", "Loss"),
        GameHistoryItem("2024-08-23", "Player 3", "Draw")
    )

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("main_menu") { MainMenuScreen(navController) }
        composable("game_mode_selection") { GameModeSelectionScreen(navController) }
        composable("bot_level_selection") { BotLevelSelectionScreen(navController) }
        composable("game") { ChessBoardScreen(navController) }
        composable("pause") { PauseScreen(navController) }
        composable("game_result/{winner}") { backStackEntry ->
            val winner = backStackEntry.arguments?.getString("winner")
            GameResultScreen(navController, winner)
        }
        composable("profile") { ProfileScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("game_history") {
            GameHistoryScreen(navController, sampleHistory)
        }
        //composable("game_analysis") { GameAnalysisScreen(navController) }
        composable("help") { HelpScreen(navController) }
    }
}
