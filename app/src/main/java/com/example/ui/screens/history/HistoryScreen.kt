package com.example.ui.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "Riwayat Transaksi",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Filter Chips
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = true, onClick = {}, label = { Text("Semua") })
            FilterChip(selected = false, onClick = {}, label = { Text("Sukses") })
            FilterChip(selected = false, onClick = {}, label = { Text("Pending") })
            FilterChip(selected = false, onClick = {}, label = { Text("Gagal") })
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item { HistoryItem(title = "Telkomsel Pulsa 50.000", date = "29 Mei 2026, 14:30", price = "Rp 50.500", status = "Sukses", icon = Icons.Default.PhoneAndroid) }
            item { HistoryItem(title = "Mobile Legends 86 Diamonds", date = "28 Mei 2026, 09:15", price = "Rp 21.000", status = "Sukses", icon = Icons.Default.Gamepad) }
            item { HistoryItem(title = "Token PLN 100.000", date = "27 Mei 2026, 18:45", price = "Rp 100.500", status = "Pending", icon = Icons.Default.ElectricBolt) }
        }
    }
}

@Composable
fun HistoryItem(title: String, date: String, price: String, status: String, icon: ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(date, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f), fontSize = 12.sp)
            }
            
            Column(horizontalAlignment = Alignment.End) {
                Text(price, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                
                val statusColor = when (status) {
                    "Sukses" -> Color(0xFF00C853)
                    "Pending" -> Color(0xFFFFA000)
                    else -> Color(0xFFD32F2F)
                }
                
                Text(status, color = statusColor, fontSize = 12.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}
