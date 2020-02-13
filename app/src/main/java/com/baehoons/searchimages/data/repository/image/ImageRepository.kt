package com.baehoons.searchimages.data.repository.image

import com.baehoons.searchimages.data.remote.kakao.request.ImageSearchRequest
import com.baehoons.searchimages.data.repository.image.model.ImageDocument
import com.baehoons.searchimages.data.repository.image.model.ImageSearchResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ImageRepository {

    fun getImages(imageSearchRequest: ImageSearchRequest): Single<ImageSearchResponse>

    fun getAllFavoriteImages(): Single<List<ImageDocument>>

    fun saveFavoriteImage(imageDocument: ImageDocument): Completable

    fun deleteFavoriteImage(imageDocument: ImageDocument): Completable

    fun observeChangingFavoriteImage(): Observable<ImageDocument>

}