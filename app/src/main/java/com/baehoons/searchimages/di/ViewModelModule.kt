package com.baehoons.searchimages.di

import com.baehoons.searchimages.presentation.favorite.FavoriteImagesViewModel
import com.baehoons.searchimages.presentation.detail.ImageDetailViewModel
import com.baehoons.searchimages.presentation.search.backpress.BackPressViewModel
import com.baehoons.searchimages.presentation.search.imagesearch.ImageSearchViewModel
import com.baehoons.searchimages.presentation.search.searchbox.SearchBoxViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {

    viewModel {
        BackPressViewModel(get())
    }

    viewModel {
        SearchBoxViewModel(get(), get())
    }

    viewModel {
        ImageSearchViewModel(get(), get(), get())
    }

    viewModel {
        ImageDetailViewModel(get(), get())
    }

    viewModel {
        FavoriteImagesViewModel(get(), get())
    }
}