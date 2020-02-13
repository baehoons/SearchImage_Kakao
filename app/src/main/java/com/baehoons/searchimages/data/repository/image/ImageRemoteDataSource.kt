package com.baehoons.searchimages.data.repository.image

import com.baehoons.searchimages.data.remote.kakao.request.ImageSearchRequest
import com.baehoons.searchimages.data.repository.image.model.ImageSearchResponse
import io.reactivex.Single

interface ImageRemoteDataSource {

    fun getImages(imageSearchRequest: ImageSearchRequest): Single<ImageSearchResponse>

}