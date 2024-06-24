package com.example.sprapplication

import android.app.Application
import com.example.data.appbar.repository.AppBarCommonRepository
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@HiltAndroidApp
class App : Application()
