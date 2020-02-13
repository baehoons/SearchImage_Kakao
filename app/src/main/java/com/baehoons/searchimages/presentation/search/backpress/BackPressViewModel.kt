package com.baehoons.searchimages.presentation.search.backpress

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.baehoons.searchimages.R
import com.baehoons.searchimages.extension.TAG
import com.baehoons.searchimages.presentation.base.BaseViewModel
import com.baehoons.searchimages.presentation.common.livedata.SingleLiveEvent
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject

class BackPressViewModel(
    application: Application
) : BaseViewModel(application) {

    companion object {
        private const val FINISH_TIME_LIMIT = 2000
    }

    private val backPressBehaviorSubject = BehaviorSubject.createDefault(0L)

    private val _finishEvent = SingleLiveEvent<Unit>()
    val finishEvent: LiveData<Unit> = _finishEvent

    init {
        observeBackPressBehaviorSubject()
    }

    fun onBackPress() {
        backPressBehaviorSubject.onNext(System.currentTimeMillis())
    }

    private fun observeBackPressBehaviorSubject() {
        backPressBehaviorSubject.buffer(2, 1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ time ->
                if (time[1] - time[0] < FINISH_TIME_LIMIT) {
                    _finishEvent.call()
                } else {
                    updateShowMessage(R.string.back_press_guide_message)
                }
            }, { throwable ->
                Log.d(TAG, throwable.message ?: "unknown error")
            })
            .disposeByOnCleared()
    }
}