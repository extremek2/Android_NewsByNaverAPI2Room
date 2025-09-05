package com.example.mynavernewsapiapplication.retrofit


data class NaverNewsDTO(
    val lastBuildDate: String,
    val total: String,
    val start: Int,
    val display: Int,
    val items: List<NewsItem>
)

data class NewsItem(
    val title : String,
    val originallink : String,
    val link : String,
    val description : String,
    val pubDate : String
)
