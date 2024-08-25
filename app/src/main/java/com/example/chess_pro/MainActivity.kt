package com.example.chess_pro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.chess_pro.ui.theme.Chess_proTheme
import ui.ChessNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chess_proTheme {
                val navController = rememberNavController()
                ChessNavHost(navController = navController)
            }
        }
    }
}