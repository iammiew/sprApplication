package com.example.data.common.interceptor

import androidx.multidex.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.internal.platform.Platform

val loggingInterceptor = LoggingInterceptor.Builder()
    .setLevel(Level.BASIC)
    .log(Platform.INFO)
    .request("MyApp_LogRequest")
    .response("MyApp_LogResponse")
    .addHeader("version", BuildConfig.VERSION_NAME)
    .build()