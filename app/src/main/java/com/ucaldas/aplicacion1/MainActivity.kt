package com.ucaldas.aplicacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ucaldas.aplicacion1.ui.theme.HeroCard

private val Background = Color(0xFFF4F7FC)
private val Navy = Color(0xFF10182B)
private val Blue = Color(0xFF275DAD)
private val Cyan = Color(0xFF72E0F4)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Aplicacion1Theme { AppNavigation() } }
    }
}

@Composable
fun Aplicacion1Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = androidx.compose.material3.lightColorScheme(
            primary = Blue, secondary = Cyan, background = Background, surface = Color.White
        ),
        content = content
    )
}

@Composable
fun ListaSuperHeroes(
    superheroes: List<Nombres>,
    onVerDetalle: (Int) -> Unit,
    esVillano: Boolean = false
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Background),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth().background(
                    Brush.linearGradient(listOf(Navy, if (esVillano) Color(0xFF8B2635) else Blue)),
                    shape = RoundedCornerShape(26.dp)
                ).padding(22.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(if (esVillano) Icons.Default.Warning else Icons.Default.Bolt, contentDescription = null, tint = Cyan)
                    Text(if (esVillano) "HALL OF VILLAINS" else "HALL OF HEROES", color = Cyan,
                        style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    if (esVillano) "Conoce a los enemigos más temibles" else "Conoce a tus superhéroes favoritos",
                    color = Color.White, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Black
                )
                Spacer(Modifier.height(8.dp))
                Text("${superheroes.size} ${if (esVillano) "villanos" else "héroes"} registrados · Toca una tarjeta para ver su expediente",
                    color = Color(0xFFD7E6FF), style = MaterialTheme.typography.bodyMedium)
            }
        }
        items(superheroes, key = { it.id }) { personaje ->
            HeroCard(hero = personaje, onClick = { onVerDetalle(personaje.id) }, esVillano = esVillano)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleSuperHeroe(hero: Nombres, onVolver: () -> Unit, esVillano: Boolean = false) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (esVillano) "Expediente del villano" else "Expediente del héroe", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    androidx.compose.material3.IconButton(onClick = onVolver) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background, titleContentColor = Navy,
                    navigationIconContentColor = Navy)
            )
        }, containerColor = Background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { HeroCard(hero = hero, option = 1, esVillano = esVillano) }
            item {
                Button(onClick = onVolver, modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 15.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Blue)) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                    Spacer(Modifier.padding(horizontal = 4.dp))
                    Text("Volver a la lista")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Utils.Rutas.LISTA) {
        composable(Utils.Rutas.LISTA) {
            var pestanaSeleccionada by remember { mutableIntStateOf(0) }
            Scaffold(
                topBar = {
                    Column {
                        TopAppBarHero()
                        TabRow(selectedTabIndex = pestanaSeleccionada, containerColor = Background) {
                            Tab(selected = pestanaSeleccionada == 0, onClick = { pestanaSeleccionada = 0 },
                                text = { Text("Héroes", fontWeight = FontWeight.Bold) }, icon = { Icon(Icons.Default.Groups, contentDescription = null) })
                            Tab(selected = pestanaSeleccionada == 1, onClick = { pestanaSeleccionada = 1 },
                                text = { Text("Villanos", fontWeight = FontWeight.Bold) }, icon = { Icon(Icons.Default.Warning, contentDescription = null) })
                        }
                    }
                }, containerColor = Background
            ) { innerPadding ->
                Box(Modifier.padding(innerPadding)) {
                    val esVillano = pestanaSeleccionada == 1
                    ListaSuperHeroes(
                        superheroes = if (esVillano) listaVillanos else listaNombres,
                        esVillano = esVillano,
                        onVerDetalle = { id -> navController.navigate(Utils.Rutas.detalle(id, esVillano)) }
                    )
                }
            }
        }
        composable(
            route = Utils.Rutas.DETALLE,
            arguments = listOf(navArgument("id") { type = NavType.IntType }, navArgument("villano") { type = NavType.BoolType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            val esVillano = backStackEntry.arguments?.getBoolean("villano") ?: false
            val lista = if (esVillano) listaVillanos else listaNombres
            val personaje = lista.firstOrNull { it.id == id }
            if (personaje != null) DetalleSuperHeroe(personaje, onVolver = { navController.popBackStack() }, esVillano = esVillano)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarHero() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Groups, contentDescription = null, tint = Blue)
                Spacer(Modifier.padding(horizontal = 4.dp))
                Text("Superhéroes y villanos", fontWeight = FontWeight.ExtraBold, color = Navy)
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Background)
    )
}
