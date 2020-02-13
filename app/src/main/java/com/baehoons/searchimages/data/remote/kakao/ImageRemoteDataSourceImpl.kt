package com.baehoons.searchimages.data.remote.kakao

import com.baehoons.searchimages.data.remote.kakao.request.ImageSearchRequest
import com.baehoons.searchimages.data.repository.image.ImageRemoteDataSource
import com.baehoons.searchimages.data.repository.image.model.ImageSearchResponse
import com.baehoons.searchimages.data.remote.kakao.response.mapper.KakaoImageSearchEntityMapper
import com.baehoons.searchimages.data.remote.kakao.transformer.error.SingleExceptionTransformer
import io.reactivex.Single

class ImageRemoteDataSourceImpl(
    private val kakaoSearchApi: KakaoSearchApi
) : ImageRemoteDataSource {

    override fun getImages(imageSearchRequest: ImageSearchRequest): Single<ImageSearchResponse> {
        return imageSearchRequest.run {
            kakaoSearchApi.searchImageList(keyword, imageSortType.type, pageNumber, requiredSize)
                .map { KakaoImageSearchEntityMapper.fromEntity(it) }
                .compose(SingleExceptionTransformer())
        }
    }
}