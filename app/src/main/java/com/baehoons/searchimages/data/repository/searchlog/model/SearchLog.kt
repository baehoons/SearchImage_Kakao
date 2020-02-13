package com.baehoons.searchimages.data.repository.searchlog.model

data class SearchLog(
    val keyword: String,
    val time: Long
) : Comparable<SearchLog> {

    override fun compareTo(other: SearchLog): Int {
        return when {
            time < other.time -> 1
            time > other.time -> -1
            else -> 0
        }
    }
}