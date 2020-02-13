package com.baehoons.searchimages.data.repository.searchlog

import com.baehoons.searchimages.data.repository.searchlog.model.SearchLog
import io.reactivex.Completable
import io.reactivex.Single

interface SearchLogRepository {

    fun deleteSearchLog(searchLog: SearchLog): Completable

    fun getAllSearchLogs(): Single<List<SearchLog>>

    fun insertOrUpdateSearchLog(keyword: String): Single<SearchLog>

    fun deleteAllSearchLogs(): Completable

}