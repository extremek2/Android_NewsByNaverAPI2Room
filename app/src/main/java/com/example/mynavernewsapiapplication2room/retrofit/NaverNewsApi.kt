package com.example.mynavernewsapiapplication2room.retrofit

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverNewsApi {
    @Headers(
        "X-Naver-Client-Id: JSDllZpFWDuX5cChZbdz",
        "X-Naver-Client-Secret: ojqGxRrYf0"
    )
    @GET("v1/search/news.json")
    suspend fun searchNews(
        //[필수] 검색어. UTF-8 인코딩 필수
        @Query("query") query: String,

        //[옵션] 한 번에 표시할 검색 결과 개수(기본값: 10, 최댓값: 100)
        @Query("display") display: Int = 10,

        //[옵션] 검색 시작 위치(기본값: 1, 최댓값: 1000)
        @Query("start") start: Int = 1,

        /* [옵션] 검색결과 정렬 방법
        sim: 정확도순으로 내림차순 정렬(기본값)
        date: 날짜순으로 내림차순 정렬*/
        @Query("sort") sort: String = "sim"

    ): NaverNewsDTO
}