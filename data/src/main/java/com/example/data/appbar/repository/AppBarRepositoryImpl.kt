package com.example.data.appbar.repository

import com.example.data.common.remote.resultResource
import com.example.data.common.remote.FirestoreDataSource
import com.example.data.appbar.model.AppBarModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppBarRepositoryImpl @Inject constructor(
    private val firestoreDatasource: FirestoreDataSource,
) : AppBarRepository {
    override fun getTopAppBarUi(): Flow<resultResource<AppBarModel?>> {
        return flow {
            firestoreDatasource.getTopAppBarUi().collect { result ->
                try {
                    when (result) {
                        is resultResource.Success -> emit(resultResource.Success(result.data))

                        is resultResource.Failure -> emit(resultResource.Failure(result.exception))
                    }
                } catch (e: Exception) {
                    emit(resultResource.Failure(e))
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}
