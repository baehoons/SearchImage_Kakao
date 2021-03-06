package com.baehoons.searchimages.extension

fun <T1, T2, R> safeLet(t1: T1?, t2: T2?, block: (T1, T2) -> R?): R? {
    return if(t1 != null && t2 != null) {
        block(t1, t2)
    } else {
        null
    }
}

fun <T1, T2, T3, R> safeLet(t1: T1?, t2: T2?, t3: T3?, block: (T1, T2, T3) -> R?): R? {
    return if(t1 != null && t2 != null && t3 != null) {
        block(t1, t2, t3)
    } else {
        null
    }
}