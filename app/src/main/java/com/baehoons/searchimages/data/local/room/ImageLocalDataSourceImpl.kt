package com.baehoons.searchimages.data.local.room

import com.baehoons.searchimages.data.local.room.dao.ImageDAO
import com.baehoons.searchimages.data.local.room.entity.mapper.ImageDocumentEntityMapper
import com.baehoons.searchimages.data.local.room.transformer.error.CompletableExceptionTransformer
import com.baehoons.searchimages.data.local.room.transformer.error.SingleExceptionTransformer
import com.baehoons.searchimages.data.repository.image.ImageLocalDataSource
import com.baehoons.searchimages.data.repository.image.model.ImageDocument
import io.reactivex.Completable
import io.reactivex.Single

class ImageLocalDataSourceImpl(
    private val imageDAO: ImageDAO
) : ImageLocalDataSource {

    override fun saveFavoriteImageDocument(imageDocument: ImageDocument): Completable {
        val imageDocumentEntity = ImageDocumentEntityMapper.toEntity(imageDocument)
        return imageDAO.insertOrUpdateImageDocument(imageDocumentEntity)
            .compose(CompletableExceptionTransformer())
    }

    override fun deleteFavoriteImageDocument(imageDocument: ImageDocument): Completable {
        return imageDAO.deleteImageDocument(imageDocument.id)
            .compose(CompletableExceptionTransformer())
    }

    override fun getAllFavoriteImages(): Single<List<ImageDocument>> {
        return imageDAO.selectAllImageDocument()
            .map { ImageDocumentEntityMapper.fromEntityList(it) }
            .compose(SingleExceptionTransformer())
    }
}