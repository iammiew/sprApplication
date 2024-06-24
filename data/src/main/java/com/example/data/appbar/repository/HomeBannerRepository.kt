package com.example.data.appbar.repository

import com.example.data.common.api.APIService
import com.example.data.common.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeBannerRepository @Inject constructor(private val apiService: APIService) {
    suspend fun getHomeBanner() = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getHomeResults()
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }
}