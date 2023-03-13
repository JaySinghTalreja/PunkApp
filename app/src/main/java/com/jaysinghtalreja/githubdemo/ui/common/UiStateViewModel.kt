package com.jaysinghtalreja.githubdemo.ui.common

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

open class UiStateViewModel : ViewModel() {
    open val isLoading = ObservableBoolean(true)
    open val isError = ObservableBoolean(false)
    open val isLoaded = ObservableBoolean(false)
    open val isEmpty = ObservableBoolean(false)

    private var _uiState : UiState = UiState.INIT

    open var uiState : UiState
        get() {
            return _uiState
        }
        set(value) {
            when(value) {
                UiState.INIT-> {
                    isLoading.set(true)
                    isEmpty.set(false)
                    isLoaded.set(false)
                    isError.set(false)
                }

                UiState.LOADING -> {
                    isLoading.set(true)
                    isEmpty.set(false)
                    isLoaded.set(false)
                    isError.set(false)
                }

                UiState.LOADED -> {
                    isLoading.set(false)
                    isEmpty.set(false)
                    isLoaded.set(true)
                    isError.set(false)
                }

                UiState.EMPTY -> {
                    isLoading.set(false)
                    isEmpty.set(true)
                    isLoaded.set(true)
                    isError.set(false)

                }

                UiState.ERROR -> {
                    isLoading.set(false)
                    isEmpty.set(false)
                    isLoaded.set(false)
                    isError.set(true)
                }
            }
            _uiState = value
        }

}