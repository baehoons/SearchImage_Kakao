package com.baehoons.searchimages.data.repository.searchlog

import com.baehoons.searchimages.data.repository.searchlog.model.SearchLog
import io.reactivex.Completable
import io.reactivex.Single

interface SearchLogLocalDataSource {

    fun insertOrUpdateSearchLog(keyword: String): Single<SearchLog>

    fun getAllSearchLogs(): Single<List<SearchLog>>

    fun deleteSearchLog(searchLog: SearchLog): Completable

    fun deleteAllSearchLogs(): Completable

}