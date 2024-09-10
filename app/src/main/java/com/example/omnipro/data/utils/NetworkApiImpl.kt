package com.example.omnipro.data.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkApiImpl @Inject constructor(@ApplicationContext val context: Context) : NetworkApi {

    private val connectivityManager: ConnectivityManager by lazy { context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    override fun isNetworkAvailable(): Boolean {
        return getActiveNetworkCapabilities()?.let {
            it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && it.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_VALIDATED
            )
        } ?: false
    }

    private fun getActiveNetworkCapabilities(): NetworkCapabilities? {
        return connectivityManager.activeNetwork?.let {
            connectivityManager.getNetworkCapabilities(it)
        }
    }

}
