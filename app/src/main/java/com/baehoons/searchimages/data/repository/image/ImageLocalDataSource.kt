package com.baehoons.searchimages.data.repository.image

import com.baehoons.searchimages.data.repository.image.model.ImageDocument
import io.reactivex.Completable
import io.reactivex.Single

interface ImageLocalDataSource {

    fun saveFavoriteImageDocument(imageDocument: ImageDocument): Completable

    fun deleteFavoriteImageDocument(imageDocument: ImageDocument): Completable

    fun getAllFavoriteImages(): Single<List<ImageDocument>>

}