package com.example.mynavernewsapiapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynavernewsapiapplication.navigation.NaverNewsAppNav
import com.example.mynavernewsapiapplication.ui.newsListScreen.NewsListScreen
import com.example.mynavernewsapiapplication.ui.newsListScreen.NewsViewModel
import com.example.mynavernewsapiapplication.ui.theme.MyNaverNewsAPIApplicationTheme
import kotlin.String

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNaverNewsAPIApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    NaverNewsAppNav(
                        modifier = Modifier.padding(innerPadding),
                        )
                }
            }
        }
    }
}
