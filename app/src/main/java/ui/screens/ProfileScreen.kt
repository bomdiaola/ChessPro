package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Información del perfil
        Text(text = "Profile", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        // Nombre del usuario
        Text(text = "Name: John Doe", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Correo electrónico del usuario
        Text(text = "Email: johndoe@example.com", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Número de partidas jugadas
        Text(text = "Games Played: 25", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Número de partidas ganadas
        Text(text = "Games Won: 15", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))

        // Botón para editar perfil
        Button(
            onClick = { /* Navegar a la pantalla de edición de perfil */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Edit Profile")
        }
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
