package com.baehoons.searchimages.di

import androidx.room.Room
import com.baehoons.searchimages.data.local.room.AppDatabase
import com.baehoons.searchimages.data.local.room.ImageLocalDataSourceImpl
import com.baehoons.searchimages.data.repository.searchlog.SearchLogLocalDataSource
import com.baehoons.searchimages.data.local.room.SearchLogLocalDataSourceImpl
import com.baehoons.searchimages.data.repository.image.ImageLocalDataSource
import org.koin.dsl.module.module

val databaseModule = module {

    single<ImageLocalDataSource> {
        ImageLocalDataSourceImpl(get())
    }

    single<SearchLogLocalDataSource> {
        SearchLogLocalDataSourceImpl(get())
    }

    single {
        get<AppDatabase>().imageDAO()
    }

    single {
        get<AppDatabase>().searchLogDao()
    }

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build()
    }


}