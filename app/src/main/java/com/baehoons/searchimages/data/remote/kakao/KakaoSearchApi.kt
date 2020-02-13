package com.baehoons.searchimages.data.remote.kakao

import com.baehoons.searchimages.data.remote.kakao.response.KakaoImageSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoSearchApi {

    @GET("search/image.json")
    fun searchImageList(
        @Query(value = "query") query: String,
        @Query(value = "sort") sortType: String,
        @Query(value = "page") pageNumber: Int,
        @Query(value = "size") requiredSize: Int
    ): Single<KakaoImageSearchResponse>

}