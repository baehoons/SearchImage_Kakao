package com.baehoons.searchimages.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baehoons.searchimages.data.local.room.entity.SearchLogEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SearchLogDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateSearchLog(searchLogEntity: SearchLogEntity): Completable

    @Query("SELECT * FROM searchLogs")
    fun selectAllSearchLogs(): Single<List<SearchLogEntity>>

    @Query("DELETE FROM searchLogs WHERE keyword = :keyword AND time = :time")
    fun deleteSearchLog(keyword: String, time: Long): Completable

    @Query("DELETE FROM searchLogs")
    fun deleteAllSearchLog(): Completable

}