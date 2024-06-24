package com.example.common.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.state.BannerUiState
import com.example.common.state.HomeBannerUiState
import com.example.data.appbar.repository.HomeBannerRepository
import com.example.data.common.utils.NetworkResult
import com.example.data.home.model.BannerItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeBannerRepository: HomeBannerRepository
) : ViewModel() {

    private val _homeBannerUiState = MutableStateFlow(HomeBannerUiState())
    val homeBannerUiState: StateFlow<HomeBannerUiState> get() = _homeBannerUiState

    private val _loadingUiState = MutableStateFlow(false)
    val loadingUiState: StateFlow<Boolean> get() = _loadingUiState

    private val _bannerUiState = MutableStateFlow(BannerUiState())
    val bannerUiState: StateFlow<BannerUiState> get() = _bannerUiState

    init {
        getHomeBanner()
    }

    private fun getHomeBanner() {
        viewModelScope.launch {
            try {
                homeBannerRepository.getHomeBanner().collect { resources ->
                    when (resources) {
                        is NetworkResult.Success -> {
                            val listBanner = resources.data.data?.layout?.filter { data ->
                                data.type == "banner"
                            }
                            _loadingUiState.update {
                                false
                            }
                            _homeBannerUiState.update {
                                HomeBannerUiState(resources.data)
                            }
                            _bannerUiState.update {
                                BannerUiState(listBanner?.get(0)?.banner)
                            }
                            Log.d("API Service", "Network Success")
                        }

                        is NetworkResult.Failure -> {
                            _loadingUiState.update {
                                false
                            }
                            _homeBannerUiState.update {
                                HomeBannerUiState(null)
                            }
                            Log.d("API Service", "Network Failed")
                        }

                        is NetworkResult.Loading -> {
                            _loadingUiState.update {
                                true
                            }
                            Log.d("API Service", "Network Loading")
                            //loading
                        }
                    }
                }
            } catch (ex: Exception) {
                Log.d("API Service", "Application Exception", ex)
            }
        }
    }
}