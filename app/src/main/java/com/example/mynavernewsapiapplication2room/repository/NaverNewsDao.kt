package com.example.mynavernewsapiapplication2room.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NaverNewsDao {
    //전체 조회 쿼리
    @Query("SELECT * FROM naver_news ORDER BY id ASC")
    fun getAllNaverNews(): Flow<List<NaverNews>>

    @Insert
    suspend fun insert(navernews: NaverNews)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(navernewsList: List<NaverNews>)

    @Update
    suspend fun update(navernews: NaverNews)

    @Delete
    suspend fun delete(navernews: NaverNews)
}