package com.baehoons.searchimages.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.baehoons.searchimages.data.local.room.dao.ImageDAO
import com.baehoons.searchimages.data.local.room.dao.SearchLogDAO
import com.baehoons.searchimages.data.local.room.entity.ImageDocumentEntity
import com.baehoons.searchimages.data.local.room.entity.SearchLogEntity

@Database(entities = [SearchLogEntity::class, ImageDocumentEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun searchLogDao(): SearchLogDAO

    abstract fun imageDAO(): ImageDAO

}