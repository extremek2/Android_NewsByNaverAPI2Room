package com.example.mynavernewsapiapplication2room.repository

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "naver_news"
)
data class NaverNews(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title : String,
    val originallink : String,
    val link : String,
    val description : String,
    val pubDate : String
)
