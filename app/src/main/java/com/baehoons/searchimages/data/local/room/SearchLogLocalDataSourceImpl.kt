package com.baehoons.searchimages.data.local.room

import com.baehoons.searchimages.data.local.room.dao.SearchLogDAO
import com.baehoons.searchimages.data.local.room.entity.SearchLogEntity
import com.baehoons.searchimages.data.repository.searchlog.SearchLogLocalDataSource
import com.baehoons.searchimages.data.repository.searchlog.model.SearchLog
import com.baehoons.searchimages.data.local.room.entity.mapper.SearchLogEntityMapper
import com.baehoons.searchimages.data.local.room.transformer.error.CompletableExceptionTransformer
import com.baehoons.searchimages.data.local.room.transformer.error.SingleExceptionTransformer
import io.reactivex.Completable
import io.reactivex.Single

class SearchLogLocalDataSourceImpl(
    private val searchLogDAO: SearchLogDAO
) : SearchLogLocalDataSource {

    override fun insertOrUpdateSearchLog(keyword: String): Single<SearchLog> {
        val newSearchLogEntity = SearchLogEntity(keyword, System.currentTimeMillis())
        return searchLogDAO.insertOrUpdateSearchLog(newSearchLogEntity)
            .toSingle { newSearchLogEntity }
            .map { SearchLogEntityMapper.fromEntity(it) }
            .compose(SingleExceptionTransformer())
    }

    override fun getAllSearchLogs(): Single<List<SearchLog>> {
        return searchLogDAO.selectAllSearchLogs()
            .map { SearchLogEntityMapper.fromEntityList(it) }
            .compose(SingleExceptionTransformer())
    }

    override fun deleteSearchLog(searchLog: SearchLog): Completable {
        return searchLogDAO.deleteSearchLog(searchLog.keyword, searchLog.time)
            .compose(CompletableExceptionTransformer())
    }

    override fun deleteAllSearchLogs(): Completable {
        return searchLogDAO.deleteAllSearchLog()
            .compose(CompletableExceptionTransformer())
    }
}