package com.example.omnipro.data.repository

import com.example.omnipro.data.remote.data.AppErrors

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val error: AppErrors) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}