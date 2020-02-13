package com.baehoons.searchimages.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "searchLogs")
data class SearchLogEntity(
    @PrimaryKey val keyword: String,
    val time: Long
)