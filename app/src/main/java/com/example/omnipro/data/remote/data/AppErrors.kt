package com.example.omnipro.data.remote.data

import com.example.omnipro.R

enum class AppErrors(val messageStringResource: Int) {
    COMMUNICATION_SERVER_ERROR(messageStringResource = R.string.server_error),
    UNABLE_COMPLETELY_PROCESS_QUERY(messageStringResource = R.string.process_query_error),
    NO_CACHE_DATA(messageStringResource = R.string.no_cache_data_error),
    UNKNOWN_ERROR(messageStringResource = R.string.unknown_error)
}