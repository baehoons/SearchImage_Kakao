package com.baehoons.searchimages.data.local.room.entity.mapper

import com.baehoons.searchimages.data.local.room.entity.ImageDocumentEntity
import com.baehoons.searchimages.data.repository.image.model.ImageDocument

object ImageDocumentEntityMapper {

    fun toEntity(imageDocument: ImageDocument): ImageDocumentEntity {
        return imageDocument.run {
            ImageDocumentEntity(
                id,
                collection,
                thumbnailUrl,
                imageUrl,
                width,
                height,
                displaySiteName,
                docUrl,
                dateTime,
                isFavorite
            )
        }
    }

    fun fromEntityList(imageDocumentEntityList: List<ImageDocumentEntity>): List<ImageDocument> {
        return imageDocumentEntityList.map { fromEntity(it) }
    }

    fun fromEntity(imageDocumentEntity: ImageDocumentEntity): ImageDocument {
        return imageDocumentEntity.run {
            ImageDocument(
                id,
                collection,
                thumbnailUrl,
                imageUrl,
                width,
                height,
                displaySiteName,
                docUrl,
                dateTime,
                isFavorite
            )
        }
    }
}