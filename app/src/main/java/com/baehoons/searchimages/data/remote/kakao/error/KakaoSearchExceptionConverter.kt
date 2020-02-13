package com.baehoons.searchimages.data.remote.kakao.transformer.error

import com.baehoons.searchimages.data.repository.error.RepositoryException
import retrofit2.HttpException
import java.net.UnknownHostException

object KakaoSearchExceptionConverter {

    fun toRepositoryException(originError: Throwable): RepositoryException {
        val errorMessage: String = originError.message ?: ""
        return when(originError) {
            is HttpException -> {
                when(originError.code()) {
                    400 -> {
                        RepositoryException.WrongRequestException(errorMessage + "wrong request")
                    }
                    401 -> {
                        RepositoryException.AuthenticationException(errorMessage + "authentication error")
                    }
                    403 -> {
                        RepositoryException.PermissionException(errorMessage + "permission error")
                    }
                    500, 502, 503 -> {
                        RepositoryException.ServerSystemException(errorMessage + "server error")
                    }
                    else -> {
                        RepositoryException.NetworkUnknownException(errorMessage + "network unknown error")
                    }
                }
            }
            is UnknownHostException -> {
                RepositoryException.NetworkNotConnectingException(errorMessage + "network not connecting error")
            }
            else -> {
                RepositoryException.UnknownException(errorMessage + "network unknown error")
            }
        }
    }
}