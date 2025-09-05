package com.example.mynavernewsapiapplication2room.ui.newsListScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    viewModel: NewsViewModel = viewModel(),
    navController: NavController,
    query: String
    ) {
    val newsList by viewModel.newsList.collectAsState()
    val daonewsList by viewModel.daonewsList.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.naverFetchNews(query)
    }
    Column( // 상위 컨테이너로 Column 사용
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        //newsList 영역
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(daonewsList) { news ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .clickable {
                            val encodedUrl = URLEncoder.encode(news.link, StandardCharsets.UTF_8.toString())
                            navController.navigate(("webview/$encodedUrl"))
                        },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(text = news.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = news.description, style = MaterialTheme.typography.bodyMedium)
                        Text(text = news.pubDate, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}