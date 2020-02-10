package com.suraj.greenlightplanetandroidassignment.data.source

import android.content.Context
import com.suraj.greenlightplanetandroidassignment.App
import com.suraj.greenlightplanetandroidassignment.data.source.remote.RemoteDataSource
import com.suraj.greenlightplanetandroidassignment.util.NetworkUtil

object DataRepository : DataSource {

    val remoteDataSource: DataSource
    val applicationContext: Context

    init {
        remoteDataSource = RemoteDataSource()
        applicationContext = App.context!!
    }

    override fun getData(callback: DataSource.Callback) {
        if (NetworkUtil.isConnectedToInternet(applicationContext)) {
            remoteDataSource.getData(callback)
        } else {
            callback.onError("Not connected to Internet. Please connect to internet and try again")
        }
    }

}