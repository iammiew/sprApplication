package com.example.common.state

import com.example.data.appbar.model.AppBarModel
import com.example.data.home.model.BannerItem
import com.example.data.home.model.HomeResultModel


data class AppBarUiState(
    val data: AppBarModel? = null,
    val message: String? = null,
)

data class HomeBannerUiState(
    val data: HomeResultModel? = null,
    val message: String? = null
)

data class BannerUiState(
    val data: List<BannerItem>? = null,
    val message: String? = null
)