package com.baehoons.searchimages.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

fun <T> Observable<T>.throttleFirstWithHalfSecond(): Observable<T> {
    return throttleFirst(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())
}
