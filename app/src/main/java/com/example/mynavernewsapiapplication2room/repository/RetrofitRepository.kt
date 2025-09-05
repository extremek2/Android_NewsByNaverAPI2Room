package com.example.mynavernewsapiapplication2room.repository

import com.example.mynavernewsapiapplication2room.retrofit.NaverNewsApi
import com.example.mynavernewsapiapplication2room.retrofit.NaverNewsDTO

class RetrofitRepository(private val retrofitApi: NaverNewsApi) {
    suspend fun naverFetchNews(query: String): NaverNewsDTO = retrofitApi.searchNews(query)
}
