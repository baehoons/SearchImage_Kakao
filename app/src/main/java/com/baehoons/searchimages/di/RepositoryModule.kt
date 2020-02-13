package com.baehoons.searchimages.di

import com.baehoons.searchimages.data.repository.image.ImageRepository
import com.baehoons.searchimages.data.repository.image.ImageRepositoryImpl
import com.baehoons.searchimages.data.repository.searchlog.SearchLogRepository
import com.baehoons.searchimages.data.repository.searchlog.SearchLogRepositoryImpl
import org.koin.dsl.module.module

val repositoryModule = module {

    single<ImageRepository> {
        ImageRepositoryImpl(get(), get())
    }

    single<SearchLogRepository> {
        SearchLogRepositoryImpl(get())
    }
}