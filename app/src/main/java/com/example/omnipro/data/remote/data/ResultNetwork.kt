package com.example.omnipro.data.remote.data


sealed class ResultNetwork<out T> {
    data class Success<out T>(val data: T) : ResultNetwork<T>()
    data class FetchError(val error: AppErrors) : ResultNetwork<Nothing>()
    data class GraphqlError(val error: AppErrors) : ResultNetwork<Nothing>()
}