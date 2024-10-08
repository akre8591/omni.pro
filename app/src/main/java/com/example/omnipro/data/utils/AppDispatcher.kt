package com.example.omnipro.data.utils

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatcher {
    fun io(): CoroutineDispatcher
    fun unconfined(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
}