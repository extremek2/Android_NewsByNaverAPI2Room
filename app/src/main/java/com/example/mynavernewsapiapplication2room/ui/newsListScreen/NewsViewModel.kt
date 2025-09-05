package com.example.mynavernewsapiapplication2room.ui.newsListScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavernewsapiapplication2room.repository.NaverNewsDatabase
import com.example.mynavernewsapiapplication2room.repository.RetrofitRepository
import com.example.mynavernewsapiapplication2room.retrofit.NewsItem
import com.example.mynavernewsapiapplication2room.retrofit.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(application: Application): AndroidViewModel(application) {
    val dao = NaverNewsDatabase.getInstance(application).naverNewsDao()
    private val _newsList = MutableStateFlow<List<NewsItem>>(emptyList())
    val newsList: StateFlow<List<NewsItem>> = _newsList

//    private val _daonewsList = MutableStateFlow<List<NaverNews>>(emptyList())
//    val daonewsList: StateFlow<List<NaverNews>> = _daonewsList.asStateFlow()


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
//
//    //dao
//    fun insertDao() {
//        viewModelScope.launch {
//            for (row in newsList.value) {
//                dao.insert(
//                    NaverNews(
//                        title = row.title,
//                        originallink = row.originallink,
//                        link = row.link,
//                        description = row.description,
//                        pubDate = row.pubDate
//                    )
//                )
//            }
//        }
//    }
//}