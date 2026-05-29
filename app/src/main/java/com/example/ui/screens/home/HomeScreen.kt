package com.example.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.navigation.NavController
import com.example.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item { HeaderSection() }
        item { BalanceSection() }
        item { MenuGridSection(navController) }
        item { PromoBannerSection() }
        item { PopularProductsSection(navController) }
    }
}

// Keep existing HeaderSection, BalanceSection, BalanceActionItem, MenuGridSection, MenuItem, PromoBannerSection

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.secondary), // Slate 900
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.ElectricBolt, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "ZXPedia",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.5).sp,
                    fontSize = 20.sp
                )
                Text(
                    text = "DIGITAL PAYMENT",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 1.5.sp,
                    fontSize = 10.sp
                )
            }
        }
        IconButton(
            onClick = { /* Notifications */ },
            modifier = Modifier.background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f), CircleShape)
        ) {
            Icon(Icons.Default.Notifications, contentDescription = "Notifikasi", tint = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
fun BalanceSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary) // Slate 900
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text("Saldo ZXPedia", color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Rp 1.450.250", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 28.sp)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BalanceActionItem(icon = Icons.Default.Add, label = "Isi Saldo")
                BalanceActionItem(icon = Icons.Default.Send, label = "Kirim")
                BalanceActionItem(icon = Icons.Default.History, label = "Riwayat")
                BalanceActionItem(icon = Icons.Default.QrCodeScanner, label = "QRIS")
            }
        }
    }
}

@Composable
fun BalanceActionItem(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable { }) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = label, tint = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(label, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun MenuGridSection(navController: NavController) {
    Column {
        Text(
            "Kategori Pilihan",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            MenuItem(icon = Icons.Default.PhoneAndroid, label = "Pulsa", onClick = { navController.navigate(Routes.PulsaTopUp) })
            MenuItem(icon = Icons.Default.DataUsage, label = "Paket Data", onClick = { navController.navigate(Routes.PulsaTopUp) })
            MenuItem(icon = Icons.Default.ElectricBolt, label = "Token PLN", onClick = { })
            MenuItem(icon = Icons.Default.Gamepad, label = "Topup Game", onClick = { })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            MenuItem(icon = Icons.Default.AccountBalanceWallet, label = "E-Wallet", onClick = { })
            MenuItem(icon = Icons.Default.ConfirmationNumber, label = "Voucher", onClick = { })
            MenuItem(icon = Icons.Default.Receipt, label = "Tagihan", onClick = { })
            MenuItem(icon = Icons.Default.MoreHoriz, label = "Lainnya", onClick = { })
        }
    }
}

@Composable
fun MenuItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(72.dp).clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier.size(56.dp),
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface,
            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f)),
            shadowElevation = 1.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = label, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(28.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            label.uppercase(),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = (-0.2).sp,
            maxLines = 1
        )
    }
}

@Composable
fun PromoBannerSection() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(3) { index ->
            Card(
                modifier = Modifier
                    .width(280.dp)
                    .height(140.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.CenterStart) {
                    Column {
                        Text("PROMO SPESIAL", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("Diskon 50% Topup\nMobile Legends", color = Color.White, fontSize = 18.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun PopularProductsSection(navController: NavController) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Topup Game Terpopuler",
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            TextButton(onClick = {  }) {
                Text("Lihat Semua", color = MaterialTheme.colorScheme.primary)
            }
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GameItem("Mobile Legends", "Moonton", onClick = { navController.navigate(Routes.gameTopUp("Mobile Legends")) })
            GameItem("Free Fire", "Garena", onClick = { navController.navigate(Routes.gameTopUp("Free Fire")) })
            GameItem("PUBG Mobile", "Tencent", onClick = { navController.navigate(Routes.gameTopUp("PUBG Mobile")) })
        }
    }
}

@Composable
fun GameItem(title: String, dev: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.width(100.dp).clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f))
    ) {
        Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.05f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Gamepad, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(title, color = MaterialTheme.colorScheme.secondary, fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1)
            Text(dev, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f), fontSize = 10.sp)
        }
    }
}
