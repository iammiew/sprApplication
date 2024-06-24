package com.example.data.common.remote

import com.example.data.appbar.model.AppBarModel
import kotlinx.coroutines.flow.Flow

interface FirestoreDataSource {
    suspend fun getTopAppBarUi(): Flow<resultResource<AppBarModel?>>
}
