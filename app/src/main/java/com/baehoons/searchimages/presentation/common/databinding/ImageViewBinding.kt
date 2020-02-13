package com.baehoons.searchimages.presentation.common.databinding

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.baehoons.searchimages.extension.loadImageWithCenterCrop
import com.baehoons.searchimages.extension.loadImageWithCenterInside

@BindingAdapter(value = ["loadImageWithCenterInside", "roundedCorners", "loadingProgressBar"], requireAll = false)
fun loadImageWithCenterInside(
    imageView: ImageView,
    imageUrl: String?,
    roundedCorners: Int = 0,
    progressBar: ProgressBar? = null
) {
    imageView.loadImageWithCenterInside(imageUrl, roundedCorners, progressBar)
}

@BindingAdapter(value = ["loadImageWithCenterCrop", "roundedCorners", "loadingProgressBar"], requireAll = false)
fun loadImageWithCenterCrop(
    imageView: ImageView,
    imageUrl: String?,
    roundedCorners: Int = 0,
    progressBar: ProgressBar? = null
) {
    imageView.loadImageWithCenterCrop(imageUrl, roundedCorners, progressBar)
}

@BindingAdapter("srcAlpha")
fun setSrcAlpha(imageView: ImageView, alpha: Int) {
    imageView.drawable?.alpha = alpha
}