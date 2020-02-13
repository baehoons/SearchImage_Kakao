package com.baehoons.searchimages.presentation.favorite

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.baehoons.searchimages.data.repository.image.ImageRepository
import com.baehoons.searchimages.data.repository.image.model.ImageDocument
import com.baehoons.searchimages.extension.*
import com.baehoons.searchimages.presentation.base.BaseViewModel
import com.baehoons.searchimages.presentation.common.livedata.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers

class FavoriteImagesViewModel(
    application: Application,
    private val imageRepository: ImageRepository
) : BaseViewModel(application) {

    private val _favoriteImages = MutableLiveData<MutableList<ImageDocument>>()
    val favoriteImages: LiveData<List<ImageDocument>> = Transformations.map(_favoriteImages) { it?.toList() }

    private val _moveToDetailScreenEvent = SingleLiveEvent<ImageDocument>()
    val moveToDetailScreenEvent: LiveData<ImageDocument> = _moveToDetailScreenEvent

    init {
        observeChangingFavoriteImage()
    }

    fun loadFavoriteImageList() {
        imageRepository.getAllFavoriteImages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ receivedFavoriteImages ->
                _favoriteImages.value = receivedFavoriteImages.toMutableList()
            }, { throwable ->
                Log.d(TAG, throwable.message)
            })
            .disposeByOnCleared()
    }

    fun onClickImage(imageDocument: ImageDocument) {
        _moveToDetailScreenEvent.value = imageDocument
    }

    private fun observeChangingFavoriteImage() {
        imageRepository.observeChangingFavoriteImage()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ changedImageDocument ->
                with(changedImageDocument) {
                    _favoriteImages.removeFirst { it.id == id }
                    if(isFavorite) {
                        _favoriteImages.add(this)
                    }
                }
            }, {
                Log.d(TAG, it.message)
            })
            .disposeByOnCleared()
    }
}