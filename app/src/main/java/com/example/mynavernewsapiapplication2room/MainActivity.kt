package com.example.mynavernewsapiapplication2room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mynavernewsapiapplication2room.navigation.NaverNewsAppNav
import com.example.mynavernewsapiapplication2room.ui.theme.MyNaverNewsAPIApplicationTheme

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
