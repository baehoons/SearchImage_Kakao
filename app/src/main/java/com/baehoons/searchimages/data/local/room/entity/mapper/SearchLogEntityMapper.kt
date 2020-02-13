package com.baehoons.searchimages.data.local.room.entity.mapper

import com.baehoons.searchimages.data.local.room.entity.SearchLogEntity
import com.baehoons.searchimages.data.repository.searchlog.model.SearchLog

object SearchLogEntityMapper {

    fun fromEntity(searchLogEntity: SearchLogEntity): SearchLog = searchLogEntity.run { SearchLog(keyword, time) }

    fun fromEntityList(searchLogEntityList: List<SearchLogEntity>) = searchLogEntityList.map { SearchLog(it.keyword, it.time) }

}