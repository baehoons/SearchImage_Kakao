package com.baehoons.searchimages.data.local.room.transformer.error

import androidx.room.EmptyResultSetException
import com.baehoons.searchimages.data.repository.error.RepositoryException

object RoomExceptionConverter {

    fun toRepositoryException(throwable: Throwable): RepositoryException {
        val errorMessage: String = throwable.message ?: ""
        return when(throwable) {
            is EmptyResultSetException -> {
                RepositoryException.NotFoundException(errorMessage + "no result error")
            }
            else -> {
                RepositoryException.DatabaseUnknownException(errorMessage + "database unknown error")
            }
        }
    }
}