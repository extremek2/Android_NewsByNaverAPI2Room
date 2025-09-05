package com.example.mynavernewsapiapplication2room.repository

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "naver_news"
)
data class NaverNews(
    @PrimaryKey
    val link : String,
    val title : String,
    val originallink : String,
    val description : String,
    val pubDate : String,
    val keyword : String
)
