package com.example.mynavernewsapiapplication.repository

import com.example.mynavernewsapiapplication.retrofit.NaverNewsApi
import com.example.mynavernewsapiapplication.retrofit.NaverNewsDTO

class RetrofitRepository(private val retrofitApi: NaverNewsApi) {
    suspend fun naverFetchNews(query: String): NaverNewsDTO = retrofitApi.searchNews(query)
}
