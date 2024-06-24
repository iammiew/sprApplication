package com.example.data.common.di

import com.example.data.common.remote.FirestoreDataSource
import com.example.data.common.remote.FirestoreDatasourceImpl
import com.example.data.appbar.repository.AppBarRepository
import com.example.data.appbar.repository.AppBarRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractionModule {

    @Binds
    @Singleton
    abstract fun bindFirestoreDatasorce(firestoreDatasourceImpl: FirestoreDatasourceImpl): FirestoreDataSource

    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: AppBarRepositoryImpl): AppBarRepository
}
