package com.example.omnipro.data.repository

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val errorMessage: String) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}