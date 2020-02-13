package com.baehoons.searchimages.data.remote.kakao.response.mapper

import com.baehoons.searchimages.data.remote.kakao.response.KakaoImageSearchResponse
import com.baehoons.searchimages.data.repository.image.model.ImageDocument
import com.baehoons.searchimages.data.repository.image.model.ImageSearchMeta
import com.baehoons.searchimages.data.repository.image.model.ImageSearchResponse

object KakaoImageSearchEntityMapper {

    fun fromEntity(remoteEntity: KakaoImageSearchResponse): ImageSearchResponse {
        return remoteEntity.run {
            val imageSearchMeta = kakaoImageSearchMeta.run {
                ImageSearchMeta(isEnd)
            }

            val imageDocumentList = kakaoImageDocuments.map {
                ImageDocument(
                    "${it.imageUrl}&${it.docUrl}",
                    it.collection,
                    it.thumbnailUrl,
                    it.imageUrl,
                    it.width,
                    it.height,
                    it.displaySiteName,
                    it.docUrl,
                    it.dateTime,
                    false
                )
            }

            ImageSearchResponse(imageSearchMeta, imageDocumentList)
        }
    }

}