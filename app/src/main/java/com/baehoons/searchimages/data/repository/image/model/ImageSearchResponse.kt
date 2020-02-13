package com.baehoons.searchimages.data.repository.image.model

data class ImageSearchResponse(
    val imageSearchMeta: ImageSearchMeta,
    val imageDocuments: List<ImageDocument>
)