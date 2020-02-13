package com.baehoons.searchimages.data.remote.kakao.response

import com.google.gson.annotations.SerializedName

data class KakaoImageSearchResponse(
    @SerializedName("meta") val kakaoImageSearchMeta: KakaoImageSearchMetaInfo,
    @SerializedName("documents") val kakaoImageDocuments: List<KakaoImageDocument>
)