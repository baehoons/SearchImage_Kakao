package com.baehoons.searchimages.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "imageDocuments")
data class ImageDocumentEntity(
    @PrimaryKey val id: String,
    val collection: String,
    val thumbnailUrl: String,
    val imageUrl: String,
    val width: Int,
    val height: Int,
    val displaySiteName: String,
    val docUrl: String,
    val dateTime: String,
    val isFavorite: Boolean
)

