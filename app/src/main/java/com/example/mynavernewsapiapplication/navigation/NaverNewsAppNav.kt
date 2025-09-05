package com.example.mynavernewsapiapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynavernewsapiapplication.ui.newsListScreen.NewsListScreen
import com.example.mynavernewsapiapplication.ui.newswebview.NewsWebView


@Composable
fun NaverNewsAppNav(modifier: Modifier = Modifier,
                    navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = { TopNavBar(navController) },
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            modifier = modifier.padding(innerPadding),
            navController = navController,
            startDestination = "news"
        ) {
            composable("news") {
                NewsListScreen(navController = navController, query = "코틀린")
            }
            composable("webview/{url}") { backStackEntry ->
                val url = backStackEntry.arguments?.getString("url") ?: ""
                NewsWebView(url)
            }
            composable("news/{query}") { backStackEntry ->
                val query = backStackEntry.arguments?.getString("query") ?: ""
                NewsListScreen(navController = navController, query = query)
            }
        }
    }
}