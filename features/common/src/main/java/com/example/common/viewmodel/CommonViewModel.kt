package com.example.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.state.AppBarUiState
import com.example.data.common.remote.resultResource
import com.example.data.appbar.repository.AppBarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CommonViewModel @Inject constructor(
    private val repository: AppBarRepository,
) : ViewModel() {

    private val _topAppBarUiState = MutableStateFlow(AppBarUiState())
    val topAppBarUiState: StateFlow<AppBarUiState> get() = _topAppBarUiState

    init {
        getTopAppBarUi()
    }

    private fun getTopAppBarUi() {
        viewModelScope.launch {
            repository.getTopAppBarUi().collect { resources ->
                when (resources) {
                    is resultResource.Success -> {
                        _topAppBarUiState.update {
                            AppBarUiState(resources.data)
                        }
                    }

                    is resultResource.Failure -> {
                        _topAppBarUiState.update {
                            AppBarUiState(null, resources.exception.message)
                        }
                    }
                }
            }
        }
    }

}