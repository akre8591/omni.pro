package com.example.omnipro.data.remote.data

import com.example.omnipro.R

enum class AppErrors(val messageStringResource: Int) {
    COMMUNICATION_SERVER_ERROR(messageStringResource = R.string.app_name),
    UNABLE_COMPLETELY_PROCESS_QUERY(messageStringResource = R.string.app_name),
    NO_CACHE_DATA(messageStringResource = R.string.app_name),
    UNKNOWN_ERROR(messageStringResource = R.string.app_name)
}