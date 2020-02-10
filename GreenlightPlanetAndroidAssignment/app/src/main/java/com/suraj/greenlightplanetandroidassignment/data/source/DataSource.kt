package com.suraj.greenlightplanetandroidassignment.data.source

import com.suraj.greenlightplanetandroidassignment.data.model.ServiceResponse

interface DataSource {

    fun getData(callback: Callback)

    interface Callback {
        fun onResponseReceived(response: ServiceResponse)
        fun onError(errorMsg: String)
    }
}