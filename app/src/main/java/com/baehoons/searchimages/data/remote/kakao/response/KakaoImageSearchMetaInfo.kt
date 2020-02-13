package com.baehoons.searchimages.data.remote.kakao.response

import com.google.gson.annotations.SerializedName

data class KakaoImageSearchMetaInfo(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("pageable_count") val pageableCount: Int,
    @SerializedName("is_end") val isEnd: Boolean
)