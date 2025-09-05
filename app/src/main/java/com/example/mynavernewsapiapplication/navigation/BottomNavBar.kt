package com.example.mynavernewsapiapplication.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.mynavernewsapiapplication.ui.theme.BabySharkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar(navController: NavController) {
    var selected by remember { mutableStateOf(0) }
    NavigationBar {
        NavigationBarItem(
            selected = selected == 0,
            onClick = { navController.navigate("news") },
            icon = { Text(text = "🏠") },
            label = {
                Text(
                    text = "Home",
                    style = BabySharkTheme.typography.bottomNavBarRegular
                )
            }
        )
        NavigationBarItem(
            selected = selected == 0,
            onClick = {  },
            icon = { Text(text = "🦉") },
            label = {
                Text(
                    text = "검색",
                    style = BabySharkTheme.typography.bottomNavBarRegular
                )
            }
        )

        NavigationBarItem(
            selected = selected == 0,
            onClick = { navController.popBackStack() },
            icon = { Text(text = "🔙") },
            label = {
                Text(
                    text = "뒤로 가기",
                    style = BabySharkTheme.typography.bottomNavBarRegular
                )
            }
        )
    }
}