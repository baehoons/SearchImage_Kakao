package com.baehoons.searchimages.data.remote.kakao.request

data class ImageSearchRequest(
    val keyword: String,
    val imageSortType: ImageSortType,
    val pageNumber: Int,
    val requiredSize: Int,
    val isFirstRequest: Boolean
)