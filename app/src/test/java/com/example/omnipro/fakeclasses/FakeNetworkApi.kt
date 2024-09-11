package com.example.omnipro.fakeclasses

import com.example.omnipro.data.utils.NetworkApi

class FakeNetworkApi : NetworkApi {

    var networkAvailable = true

    override fun isNetworkAvailable(): Boolean = networkAvailable
}
