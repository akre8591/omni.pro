package com.example.omnipro.data.remote.data

import com.apollographql.apollo.api.Error

sealed class ResultNetwork<out T> {
    data class Success<out T>(val data: T) : ResultNetwork<T>()
    data class FetchError(val error: Exception) : ResultNetwork<Nothing>()
    data class GraphqlError(val listError: List<Error>) : ResultNetwork<Nothing>()
}