package com.ucaldas.aplicacion1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ucaldas.aplicacion1.Nombres

private val HeroNavy = Color(0xFF10182B)
private val HeroBlue = Color(0xFF275DAD)
private val HeroCyan = Color(0xFF72E0F4)
private val HeroMuted = Color(0xFF64748B)

@Composable
fun HeroImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeroInfo(
    hero: Nombres,
    modifier: Modifier = Modifier,
    esVillano: Boolean = false
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "${if (esVillano) "VILLANO" else "HÉROE"} #${hero.id}",
            style = MaterialTheme.typography.labelMedium,
            color = HeroBlue,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = hero.nombre,
            style = MaterialTheme.typography.headlineSmall,
            color = HeroNavy,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = hero.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            color = HeroMuted,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Poderes: ${hero.superPoderes.take(3).joinToString()}${if (hero.superPoderes.size > 3) "…" else ""}",
            style = MaterialTheme.typography.bodySmall,
            color = HeroBlue,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

private fun heroProfile(superPoderes: List<String>): String = when {
    superPoderes.any { it.contains("Inteligencia", ignoreCase = true) } &&
        superPoderes.any { it.contains("Combate", ignoreCase = true) } -> "Estratega"
    superPoderes.any { it.contains("Energía", ignoreCase = true) || it.contains("energia", ignoreCase = true) } -> "Cósmico"
    superPoderes.any { it.contains("velocidad", ignoreCase = true) } -> "Velocista"
    else -> "Titán"
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroInfoDetail(
    hero: Nombres,
    modifier: Modifier = Modifier,
    esVillano: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(HeroBlue, HeroCyan))),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = hero.nombre.firstOrNull()?.uppercase() ?: "?",
                    color = Color.White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Black
                )
            }
            Spacer(Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(if (esVillano) "PERFIL DEL VILLANO" else "PERFIL DEL HÉROE", color = HeroBlue, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                Text(hero.nombre, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold, color = HeroNavy)
                Text("Identificador ${hero.id}", color = HeroMuted, style = MaterialTheme.typography.bodySmall)
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Historia", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = HeroNavy)
            Text(hero.descripcion, style = MaterialTheme.typography.bodyLarge, color = HeroMuted)
        }

        Surface(
            color = Color(0xFFF0F6FF),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("MÉTRICAS DE CAMPO", color = HeroBlue, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.ExtraBold)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    MetricBlock("PODERES", hero.superPoderes.size.toString(), Modifier.weight(1f))
                    MetricBlock("PERFIL", heroProfile(hero.superPoderes), Modifier.weight(1f))
                    MetricBlock("RANGO", if (hero.superPoderes.size >= 5) "Élite" else "Avanzado", Modifier.weight(1f))
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Superpoderes", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = HeroNavy)
            Text(if (esVillano) "Habilidades y recursos conocidos de este villano" else "Habilidades conocidas de este héroe", style = MaterialTheme.typography.bodyMedium, color = HeroMuted)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                hero.superPoderes.forEach { poder ->
                    AssistChip(
                        onClick = {},
                        label = { Text(poder) },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color(0xFFE5F7FB),
                            labelColor = HeroBlue
                        )
                    )
                }
            }
        }

        Surface(
            color = HeroNavy,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("RESUMEN TÁCTICO", color = HeroCyan, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.ExtraBold)
                Text(
                    text = if (esVillano) "${hero.nombre} destaca como ${heroProfile(hero.superPoderes).lowercase()} con ${hero.superPoderes.size} habilidades registradas. Sus capacidades lo convierten en una amenaza que requiere atención táctica." else "${hero.nombre} destaca como ${heroProfile(hero.superPoderes).lowercase()} con ${hero.superPoderes.size} habilidades registradas. Su combinación de capacidades lo convierte en un aliado valioso en misiones de alto riesgo.",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun MetricBlock(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(label, color = HeroMuted, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Text(value, color = HeroNavy, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun HeroCard(
    hero: Nombres,
    onClick: (() -> Unit)? = null,
    option: Int = 0,
    modifier: Modifier = Modifier,
    esVillano: Boolean = false
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            HeroImage(
                imageUrl = hero.imagenUrl,
                contentDescription = hero.nombre,
                modifier = Modifier
            )
            if (option == 0) {
                HeroInfo(hero = hero, esVillano = esVillano)
            } else {
                HeroInfoDetail(hero = hero, esVillano = esVillano)
            }
        }
    }
}
