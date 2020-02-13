package com.baehoons.searchimages.di

import com.baehoons.searchimages.presentation.common.pageload.PageLoadConfiguration
import com.baehoons.searchimages.presentation.common.pageload.PageLoadHelper
import org.koin.dsl.module.module

val helperModule = module {

    factory {
        PageLoadHelper<String>(get())
    }

    factory {
        PageLoadConfiguration(1, 50, 50, 5)
    }

}