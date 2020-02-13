package com.baehoons.searchimages.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baehoons.searchimages.data.local.room.entity.ImageDocumentEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ImageDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateImageDocument(imageDocumentEntity: ImageDocumentEntity): Completable

    @Query("DELETE FROM imageDocuments WHERE id = :id")
    fun deleteImageDocument(id: String): Completable

    @Query("SELECT * FROM imageDocuments")
    fun selectAllImageDocument(): Single<List<ImageDocumentEntity>>

}