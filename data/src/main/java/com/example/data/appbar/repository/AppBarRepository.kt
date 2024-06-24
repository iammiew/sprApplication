package com.example.data.appbar.repository

import com.example.data.common.remote.resultResource
import com.example.data.appbar.model.AppBarModel
import kotlinx.coroutines.flow.Flow

interface AppBarRepository {
    fun getTopAppBarUi(): Flow<resultResource<AppBarModel?>>
}
