package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SettingsScreen(navController: NavHostController) {
    // Estados para las configuraciones
    var soundEnabled by remember { mutableStateOf(true) }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkThemeEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Settings", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        // Configuración del sonido
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Enable Sound")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = soundEnabled,
                onCheckedChange = { soundEnabled = it }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Configuración de las notificaciones
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Enable Notifications")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Configuración del tema oscuro
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Enable Dark Theme")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = darkThemeEnabled,
                onCheckedChange = { darkThemeEnabled = it }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Botón para volver al menú principal
        Button(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Main Menu")
        }
    }
}
