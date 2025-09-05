package com.example.mynavernewsapiapplication.ui.newsListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavernewsapiapplication.repository.RetrofitRepository
import com.example.mynavernewsapiapplication.retrofit.NewsItem
import com.example.mynavernewsapiapplication.retrofit.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(): ViewModel() {
    private val _newsList = MutableStateFlow<List<NewsItem>>(emptyList())
    val newsList: StateFlow<List<NewsItem>> = _newsList

    // 뷰모델 파라미터가 아닌 변수로 바꿔야 함 (PDF 랑 다른 부분)
    private val repository: RetrofitRepository = RetrofitClient.retrofitRepository




    fun naverFetchNews(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.naverFetchNews(query)
                _newsList.value = response.items
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}