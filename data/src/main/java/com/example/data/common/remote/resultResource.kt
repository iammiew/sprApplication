package com.example.data.common.remote

import java.lang.Exception

sealed class resultResource<out T> {
    data class Success<T>(val data: T) : resultResource<T>()
    data class Failure(val exception: Exception) : resultResource<Nothing>()
}
